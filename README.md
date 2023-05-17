"# Bootcamp-Licencias" 
It uses MySQL and will create a new Database "relationships" if able.

v1.0 ==========================================================================================================================================================================================
This API allows the user to create people and licenses. For people it needs a first and last name, and for Licenses it only needs a State.
The License number is created automatically and progressively. Also when you create a new person, if there is a License available it will be assigned automatically to this new person.
It works the same the other way around. Meaning that, if there is people without License, as soon as you create a new License it will be assigned to the first person missing a License.

v2.0 ==========================================================================================================================================================================================
This API allows the user to create people and licenses. For people it needs a first and last name, and for Licenses it needs a State, Expiration Date and a person to assign.
The License number is created automatically and progressively. Also when you create a new person, it will be available in the License creation form as long as that person doesn't have a License.
