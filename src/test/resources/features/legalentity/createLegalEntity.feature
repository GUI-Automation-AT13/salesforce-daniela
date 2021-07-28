Feature: create legal entity

  @CreateLegaEntity
  Scenario: create an opportunity with required fields.
    Given I login to Salesforce site as an admin user
    When I navigate to LegalEntity page
    When I create a new LegalEntity with fields
      | Name | new entity |
    Then A successful message is displayed
    And The title matches
    And All given details fields matches

  @CreateLegaEntity
  Scenario: create an opportunity with all fields.
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
    Then A successful message is displayed
    And The title matches
    And All given details fields matches