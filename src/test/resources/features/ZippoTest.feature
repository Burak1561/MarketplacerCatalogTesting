
Feature: User should use zippopotam.us easily
  User should get all information about zipcode 22031 in US using zippopotam.us
  Background: User connect to API
    Given User connected with api baseUrl
 Scenario: Checking all info about zipcode 22031
   Given User use zipcode 22031 as a path param on the GET request
   And Status code must be 200
   Then Content type must be "application/json"

   Scenario: Getting information about Fairfax
     Given User send GET request using path params state "VA" and city "Fairfax"
     And User should get status code 200
     And User should see latitude equal "38.8458"
     Then User should see content type as "application/json"