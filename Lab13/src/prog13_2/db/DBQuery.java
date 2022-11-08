package prog13_2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBQuery {

	public static Address readPersonAddress(String personId) throws SQLException, RecordNotFoundException {
		String queryString = "SELECT " + "p.id as id, p.firstname as firstName, p.lastname as lastName, p.ssn as ssn, "
				+ "a.addrid as addrid, a.street as street, a.city as city, a.state as state, a.zip as zip "
				+ "FROM person p, address a WHERE p.id=? AND p.id=a.id";
		Connection connection = Connector.getConnection();
		PreparedStatement query = connection.prepareStatement(queryString);

		query.setString(1, personId);
		ResultSet rs = query.executeQuery();

		if (!rs.next())
			throw new RecordNotFoundException("Person not found!");

		String addrid = rs.getString("addrid").trim();
		String id = rs.getString("id").trim();
		String firstName = rs.getString("firstName").trim();
		String lastName = rs.getString("lastName").trim();
		String ssn = rs.getString("ssn").trim();
		String street = rs.getString("street").trim();
		String city = rs.getString("city").trim();
		String state = rs.getString("state").trim();
		String zip = rs.getString("zip").trim();
		Person person = new Person(id, firstName, lastName, ssn);
		Address address = new Address(addrid, person, street, city, state, zip);

		connection.close();

		return address;
	}

	public static void savePersonAddress(Address address) throws SQLException, RecordNotFoundException, Exception {
		Connection connection = Connector.getConnection();
		Person person = address.getPerson();

		if (person.getId() == null || person.getId().equals("")) {
			PreparedStatement insertPersonQuery = connection.prepareStatement(
					"INSERT INTO person (firstname, lastname, ssn) VALUES(?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			insertPersonQuery.setString(1, person.getFirstName());
			insertPersonQuery.setString(2, person.getLastName());
			insertPersonQuery.setString(3, person.getSsn());

			int noOfRows = insertPersonQuery.executeUpdate();

			if (noOfRows == 0) {
				connection.close();
				throw new Exception("Failed to create the record!");
			}

			ResultSet rs = insertPersonQuery.getGeneratedKeys();

			if (!rs.next()) {
				connection.close();
				throw new Exception("Failed to create the record!");
			}

			String personId = rs.getString(1);

			PreparedStatement insertAddressQuery = connection.prepareStatement(
					"INSERT INTO address (id, street, city, state, zip) VALUES(?, ?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			insertAddressQuery.setString(1, personId);
			insertAddressQuery.setString(2, address.getStreet());
			insertAddressQuery.setString(3, address.getCity());
			insertAddressQuery.setString(4, address.getState());
			insertAddressQuery.setString(5, address.getZip());

			noOfRows = insertAddressQuery.executeUpdate();

			if (noOfRows == 0) {
				connection.close();
				throw new Exception("Created person but failed to create the address record!");
			}

			rs = insertAddressQuery.getGeneratedKeys();

			if (!rs.next()) {
				connection.close();
				throw new Exception("Created person but failed to create the address record!");
			}
		} else {
			String findPersonQueryString = "SELECT id FROM person WHERE id=?";
			PreparedStatement findPersonQuery = connection.prepareStatement(findPersonQueryString);
			findPersonQuery.setString(1, person.getId());

			ResultSet rs = findPersonQuery.executeQuery();

			if (!rs.next()) {
				connection.close();
				throw new RecordNotFoundException("The person to be updated does not exist!");
			}

			PreparedStatement updatePersonQuery = connection
					.prepareStatement("UPDATE person SET firstname=?, lastname=?, ssn=? WHERE id=?");
			updatePersonQuery.setString(1, person.getFirstName());
			updatePersonQuery.setString(2, person.getLastName());
			updatePersonQuery.setString(3, person.getSsn());
			updatePersonQuery.setString(4, person.getId());

			int noOfPersonRows = updatePersonQuery.executeUpdate();

			if (noOfPersonRows == 0) {
				connection.close();
				throw new Exception("Failed to update the record!");
			}

			PreparedStatement updateAddressQuery = connection
					.prepareStatement("UPDATE address SET street=?, city=?, state=?, zip=? WHERE id=?");
			updateAddressQuery.setString(1, address.getStreet());
			updateAddressQuery.setString(2, address.getCity());
			updateAddressQuery.setString(3, address.getState());
			updateAddressQuery.setString(4, address.getZip());
			updateAddressQuery.setString(5, person.getId());

			int noOfAddressRows = updateAddressQuery.executeUpdate();

			if (noOfAddressRows == 0) {
				connection.close();
				throw new Exception("Failed to update the record!");
			}
		}
	}
}
