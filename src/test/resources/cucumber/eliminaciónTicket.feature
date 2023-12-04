Feature: Eliminacion de Ticket por id

  Scenario: eliminacion de Ticket por id exitosa
    Given un ticket de id 1
    And un ticket de id 2
    When elimino el ticket de id 1
    Then se elimina el ticket de id 1

  Scenario: eliminacion de Ticket por id fallida
    Given un ticket de id 1
    And un ticket de id 2
    When elimino el ticket de id 18
    Then no se elimina el ticket de id 18