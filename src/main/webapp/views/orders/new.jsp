<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Bakery</title>
  </head>
  <body>
    <h1>Add a new order</h1>
    <form action="/orders" method="post">
      <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
      </div>
      <div>
        <label>Item name:
          <input type="text" name="itemName" required>
        </label>
      </div>
      <div>
        <label>Item quantity:
          <input type="number" name="itemQuantity" required>
        </label>
      </div>
      <div>
        <p>Gluten Free:
          <label>Yes
            <input type="radio" name="glutenFree" value="y">
          </label>
          <label>No
            <input type="radio" name="glutenFree" value="n">
          </label>
        </p>
      </div>
      <div>
        <p>Vegan:
          <label>Yes
            <input type="radio" name="vegan" value="y">
          </label>
          <label>No
            <input type="radio" name="vegan" value="n">
          </label>
        </p>
      </div>
      <div>
        <label>Item image URL:
          <input type="url" name="itemImageURL" required>
        </label>
      </div>
      <div>
        <input type="submit" value="Submit">
      </div>
    </form>
  </body>
</html>