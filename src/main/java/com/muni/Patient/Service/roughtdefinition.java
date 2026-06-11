package com.muni.Patient.Service;

public class roughtdefinition {

    //differently.
    //
    //1. @PathVariable
    //
    //Used to get values that are part of the URL path.
    //
    //Example URL:
    //
    //@GetMapping("/student/{id}")
    //public String getStudent(@PathVariable int id) {
    //    return "Student ID: " + id;
    //}
    //
    //Request:
    //
    //http://localhost:8080/student/101
    //
    //Output:
    //
    //Student ID: 101
    //
    //Here, 101 is part of the URL path.
    //
    //2. @RequestParam
    //
    //Used to get values from query parameters.
    //
    //Example URL:
    //
    //@GetMapping("/student")
    //public String getStudent(@RequestParam int id) {
    //    return "Student ID: " + id;
    //}
    //
    //Request:
    //
    //http://localhost:8080/student?id=101
    //
    //Output:
    //
    //Student ID: 101
    //
    //Here, id=101 is passed as a query parameter.
    //
    //Major Difference
    //@PathVariable	@RequestParam
    //Value comes from URL path	Value comes from query string
    //Mandatory by default	Can be optional
    //Used to identify a specific resource	Used for filtering, searching, sorting
    //Example: /student/101	Example: /student?id=101

    //If your endpoint is:
    //
    //@GetMapping("/{name}")
    //public ResponseEntity<PatientResponseDTO> findByNames(@PathVariable String name) {
    //    PatientResponseDTO patientResponseDTO = patientService.findByName(name);
    //    return new ResponseEntity<>(patientResponseDTO, HttpStatus.OK);
    //}
    //
    //and the name is John Doe, the space must be URL encoded.
    //
    //URL
    //http://localhost:8081/John%20Doe
    //
    //%20 represents a space.
    //
    //A better approach is to use @RequestParam for names because names can contain spaces and special characters.
    //
    //@GetMapping("/patient")
    //public ResponseEntity<PatientResponseDTO> findByNames(@RequestParam String name) {
    //    PatientResponseDTO patientResponseDTO = patientService.findByName(name);
    //    return ResponseEntity.ok(patientResponseDTO);
    //}
    //
    //URL:
    //
    //http://localhost:8081/patient?name=John Doe
    //
    //or
    //
    //http://localhost:8081/patient?name=John%20Doe
    //
    //For IDs, use @PathVariable:
    //
    ///patient/101
    //
    //For names, search terms, filters, etc., @RequestParam is usually the better choice.
    //For name, using @RequestParam is usually better than @PathVariable.
    //
    //Better
    //@GetMapping("/patients")
    //public Patient getByName(@RequestParam String name) {
    //    return patientService.findByName(name);
    //}
    //
    //URL:
    //
    ///patients?name=John Doe
    //Not Recommended
    //@GetMapping("/patients/{name}")
    //public Patient getByName(@PathVariable String name) {
    //    return patientService.findByName(name);
    //}
    //
    //URL:
    //
    ///patients/John%20Doe
    //Why?
    //
    //Names:
    //
    //Can contain spaces (John Doe)
    //Can contain special characters (A.R. Rahman)
    //May not be unique
    //
    //IDs:
    //
    //Are unique
    //Usually contain no spaces
    //Perfect for path variables
    //Common REST Practice
    //GET /patients/123            -> Find patient by ID (@PathVariable)
    //
    //GET /patients?name=John      -> Search patient by name (@RequestParam)
    //
    //GET /patients?city=Chennai   -> Filter by city (@RequestParam)
    //
    //GET /patients?page=1&size=10 -> Pagination (@RequestParam)
}
