<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Register</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/student-register.css" />
</head>
<body>
	<div class="register-boundary">
		<h2>Registration Form</h2>
		<form action="#" class="registration-form">
			<div class ="left">
				<div class="form">
					<label for="first-name">First Name:</label>
					<input type="text" id="first-name" name="first-name" required>
				</div>
				<div class="form">
					<label for="username">Username:</label>
					<input type="text" id="username" name="username" required>
				</div>
				<div class="form">
					<label for="gender">Gender:</label>
					<select name="gender" id="gender">
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				<div class="form">
					<label for="phone-number">Phone Number:</label>
					<input type="text" id="phone-number" name="phone-number" required>
				</div>
				<div class="form">
					<label for="password">Password:</label>
					<input type="text" id="password" name="password" required>
				</div>
			</div>
			<div class="right">
				<div class="form">
					<label for="last-name">Last Name:</label>
					<input type="text" id="last-name" name="last-name" required>
				</div>
				<div class="form">
					<label for="birthday">Birthday:</label>
					<input type="date" id="birthday" name="birthday" required>
				</div>
				<div class="form">
					<label for="email">Email:</label>
					<input type="text" id="email" name="email" required>
				</div>
				<div class="form">
					<label for="subject">Subject:</label>
					<select name="subject" id="subject">
						<option value="ai">B.Sc Computing with AI</option>
						<option value="computing">B.Sc Computing</option>
						<option value="networking">B.Sc Networking</option>
						<option value="multimedia">B.Sc Multimedia</option>
					</select>
				</div>
				<div class="form">
					<label for="re-password">Confirm Password:</label>
					<input type="text" id="re-password" name="re-password" required>
				</div>
			</div>
		</form>
		<div>
			<button>Submit</button>
		</div>
	</div>
</body>
</html>