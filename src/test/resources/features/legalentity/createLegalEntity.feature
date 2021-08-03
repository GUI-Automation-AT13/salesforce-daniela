Feature: create legal entity

  @CreateLegaEntity
  Scenario: create an legal entity with required fields.
    Given I login to Salesforce site as an admin user
    When I navigate to LegalEntity page
    When I create a new LegalEntity with fields
      | Name | new entity |
    Then A successful message should be displayed
    And The header name should match in the created legal entity page
    And All given details fields should match in the created legal entity page
    When I navigate to LegalEntity page
    Then The created legal entity should be displayed on the legal entities table

  @CreateLegaEntity
  Scenario: create an legal entity with all fields.
    Given I login to Salesforce site as an admin user
    When I navigate to LegalEntity page
    When I create a new LegalEntity with fields
      | Name                  | new entity UNIQUE_ID |
      | CompanyName           | new company          |
      | LegalEntityStreet     | S. elm # 557         |
      | Description           | blue door            |
      | LegalEntityCity       | new city             |
      | LegalEntityState      | the state            |
      | LegalEntityPostalCode | 0023                 |
      | LegalEntityCountry    | boolivia             |
      | Status                | Active               |
    Then A successful message should be displayed
    And The header name should match in the created legal entity page
    And All given details fields should match in the created legal entity page
    When I navigate to LegalEntity page
    Then The created legal entity should be displayed on the legal entities table