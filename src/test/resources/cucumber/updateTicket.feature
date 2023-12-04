Feature: Update del estado/severidad/prioridad de un ticket

  Scenario: Cambio de estado de un ticket exitoso
    Given un ticket con estado "Sin Comenzar"
    When cambio el estado a "En progreso"
    Then el estado del ticket es "En progreso"

  Scenario: Cambio de prioridad de un ticket exitoso
    Given un ticket con prioridad "Baja"
    When cambio la prioridad a "Alta"
    Then la prioridad del ticket es "Alta"

  Scenario: Cambio de severidad de un ticket
    Given un ticket con severidad "S-1"
    When cambio la severidad a "S-2"
    Then la severidad del ticket es "S-2"