Feature: Como usuario, quiero realizar una búsqueda en la web Automation practice y poder logearme

  #Busqueda en el campo Search con su validacion
  @Smoke @Agus
  Scenario Outline: El usuario hace una busqueda
    Given que estoy en la pagina de web de Automation Practice
    When ingreso una busqueda <busqueda>
    Then  la palabra <busqueda> se busco realmente
    Examples:
      | busqueda |
      | dress    |


  #Feature que me logea a la pagina
  @Smoke @Agus @login
  Scenario Outline: El usuario hace un login
    Given que estoy en la pagina de web de Automation Practice
    When el usuario pulsa el botón "Sign in"
    And  el usuario ingresa su usurio '<usuario>' y su contraseña '<contrasenia>'
    Then verifico que se ha logeado correctamente y me deslogueo
    Examples:
      | usuario                      | contrasenia     |
      | warenycia.agustina@gmail.com | EstaEsUnaPrueba |



#Feature que me realiza la busqueda y comprueba que se encuentre en la pagina de busqueda
  @Smoke @Agus
  Scenario Outline: El usuario hace una busqueda
    Given que estoy en la pagina de web de Automation Practice
    When ingreso una busqueda  <busqueda>
    And la pagina me muestra los resultados, verificaa <busqueda> y selecciono los precios de menor a mayor
    Then se valida que esten bien ordenados
    Examples:
      | busqueda |
      #|t-shirt   |
      #|blouse    |

      | short    |
      # | dress    | caso donde rompe