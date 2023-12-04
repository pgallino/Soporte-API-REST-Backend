Feature: Obtencion de Ticket por id

  Scenario: Obtencion de ticket por id exitosa
    Given un ticket de id 1
    When busco ticket por id 1
    Then se retorna el ticket de id 1

  Scenario: Obtencion de ticket por id fallida
    Given un ticket de id 2
    And un ticket de id 3
    And un ticket de id 4
    When busco ticket por id 5
    Then no se encuentra el ticket