Feature: Como usuario, quiero realizar una búsqueda en la web Automation practice

@Smoke @Agus
Scenario Outline: El usuario hace una busqueda
  Given que estoy en la pagina de web de Automation Practice
  When ingreso una busqueda de vestido <busqueda>
  Then la pagina me devuelve una vista y verifica los datos
  Then  la palabra <busqueda> se busco realmente
  Then selecciono los precios de menor a mayor
  Then se valida que esten bien ordenados
    Examples:
    |busqueda|
    |short   |

