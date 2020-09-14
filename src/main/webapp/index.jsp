<html>
<body>
<form action="registration_result" method="post">
		<label for="name">User Name:</label></br>
  		<input type="text" name="name"></br></br>
  		<label for="password">Password:</label></br>
  		<input type="password" name="password"></br></br>
		<input type="submit" value="Register">
</form >
</br>
<form action="userlist" method="post">
	<input type="submit" value="Show Users">
</form>
</br>
<form action="update_result" method="post">
	<table>
		<tr><td><label for="name">Old Name:</label></td><td></td> <td><label for="name">New Name:</label></td></tr>
		<tr><td><input type="text" name="old_name"></td><td></td> <td><input type="text" name="new_name"></td><td></td><td><input type="Submit" value="Update"></td></tr>
		
	</table>
</form>
</br>
<form action="delete_result" method="post">
	<table>
		<tr><td><label for="name">User Name:</label></td></tr>
		<tr><td><input type="text" name="name"></td><td></td><td><input type="Submit" value="Delete"></td></tr>
		
	</table>

</body>

</html>
