Feature: Obtencion de Tickets por Producto y Version

  Scenario: Obtencion de ticket por producto y version exitosa
    Given un ticket del producto 1 y version 2
    When busco tickets del producto 1 y version 2
    Then se retornan los tickets del producto 1 y version 2


  Scenario: Obtencion de tickets por producto y version exitosa
    Given un ticket del producto 1 y version 2
    And un ticket del producto 1 y version 2
    And un ticket del producto 1 y version 3
    And un ticket del producto 2 y version 1
    When busco tickets del producto 1 y version 2
    Then se retornan los tickets del producto 1 y version 2

  Scenario: Obtencion de tickets por producto y version fallida
    Given un ticket del producto 1 y version 2
    And un ticket del producto 1 y version 2
    And un ticket del producto 1 y version 3
    And un ticket del producto 2 y version 1
    When busco tickets del producto 3 y version 2
    Then no se encuentran tickets del producto 3 y version 2