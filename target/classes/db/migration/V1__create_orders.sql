DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  item_name VARCHAR(255) NOT NULL,
  item_quantity INTEGER NOT NULL,
  gluten_free VARCHAR(255) NOT NULL,
  vegan VARCHAR(255) NOT NULL,
  item_image_url VARCHAR(255) NOT NULL
);