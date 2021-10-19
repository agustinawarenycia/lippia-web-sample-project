Feature: Como usuario, quiero realizar una búsqueda en la web Automation practice y poder logearme

  #Busqueda en el campo Search con su validacion

  Scenario: El usuario hace una busqueda
    Given que estoy en la pagina de web de Automation Practice
    When ingreso una busqueda dress
    Then  la palabra 'dress' se busco realmente


  #Feature que me logea a la pagina

  Scenario Outline: El usuario hace un login
    Given que estoy en la pagina de web de Automation Practice
    When el usuario pulsa el botón "Sign in"
    And  el usuario ingresa su usurio '<usuario>' y su contraseña '<contrasenia>'
    Then me redirige al inicio y verifico que se ha logeado correctamente
    Examples:
      |usuario                     |contrasenia|
      |warenycia.agustina@gmail.com|EstaEsUnaPrueba|



#Feature que me realiza la busqueda y comprueba que se encuentre en la pagina de busqueda
  @Smoke @Agus
Scenario Outline: El usuario hace una busqueda
  Given que estoy en la pagina de web de Automation Practice
  When ingreso una busqueda  <busqueda>
  Then la pagina me devuelve una vista y verifica los datos
  Then  la palabra <busqueda> se busco realmente
  Then selecciono los precios de menor a mayor
  Then se valida que esten bien ordenados
    Examples:
      | busqueda |
     # |t-shirt   |
      #|blouse     |
      |dress      |
