<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<!-- . represent current directory and base is file name from where information/design comes to this page -->
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Update the product details</h1>
				<form action="${pageContext.request.contextPath }/updateproduct" method="post">
				<div class="form-group">
						<input type="text"
							class="form-control" id="id" 
							name="id"
							value = "${product.id }"/>
							 
					</div>
					<div class="form-group">
						<label for="name">Product Name</label><input type="text"
							class="form-control" id="name" aria-describedby="emailHelp"
							name="name"
							value = "${product.name }"
							 placeholder="Enter the product name">
					</div>

					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" id="description" rows="5"
							name="description" placeholder="Enter the product name">${product.description }
							</textarea>
					</div>

					<div class="form-group">
						<label for="price">Product Price</label><input type="text"
							class="form-control" id="price" name="price"
							placeholder="Enter the product price" value = "${product.price }">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
						class="btn btn-outline-danger">Back</a>
						<!-- pageContext.request.contextPath it will give the project name otherwise on clicking back we were redirected to the root 
						page , so in order to get previous page we use this along with the mapping name i.e.(/) in this case -->
						
						<button type="submit" class="btn btn-primary">Update</button>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
