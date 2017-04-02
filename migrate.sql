CREATE TABLE hover_data (
  id INT NOT NULL AUTO_INCREMENT,
  rendering_engine VARCHAR(45) NULL,
  browser VARCHAR(45) NULL,
  platform VARCHAR(45) NULL,
  engine_version VARCHAR(45) NULL,
  css_grade VARCHAR(45) NULL,
  PRIMARY KEY (id));