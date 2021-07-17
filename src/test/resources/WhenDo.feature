Feature: WhenDO

  Scenario Outline: Como usuario de la app WhenDO
  Quiero agregar nuevos items a mi lista de tareas
  Para guardarlos en mi telefono


    Given tengo acceso a WhenDo
    When clic al boton "Agregar"
    And llenar la caja de texto Titulo con <Titulo>
    And llena la caja de texto Notas con <Notas>
    And clic al boton "Guardar"
    Then el item <Titulo> deberia ser creado
    Examples:
      |Titulo  |Notas|
      |PRUEBA1 |NOTA1|
      |PRUEBA2 |NOTA2|
      |PRUEBA3 |NOTA3|