package com.muni.Patient.Service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class TestPracticingClassTest {

    @Autowired
    private TestPracticingClass test=new TestPracticingClass();

//    @BeforeEach
//    void setUp(){
//        test=new TestPracticingClass();
//    }

    @Test
    @Order(1)
    void Test(){
        // actual what is an expectation
        int ex=5;
        int ac=test.addition(5);
        assertEquals(ex,ac,"test case fail");
    }

    @Test
    @Order(2)
    void Test1(){
        assertEquals(10,test.addition(5));

    }

//    @AfterEach
//    void close(){
//        test=null;
//    }


}



//@SpringBootTest due to i am not mention this so without running an application i can test teh test cases
//
//Exactly, Muni.
//
//When you don't use @SpringBootTest, Spring Boot does not start the application context. JUnit simply runs your Java code.
//In JUnit and Spring Boot testing, these are the most commonly used annotations at the top of the test class:
//
//1. @SpringBootTest
//
//Loads the entire Spring Boot application context.
//
//@SpringBootTest
//class PatientServiceTest {
//}
//
//Use when you want to test the full application, including Spring beans, services, repositories, etc.
//
//2. @WebMvcTest
//
//Loads only the Controller layer.
//
//@WebMvcTest(PatientController.class)
//class PatientControllerTest {
//}
//
//Use for testing REST APIs with MockMvc.
//
//3. @DataJpaTest
//
//Loads only JPA-related components.
//
//@DataJpaTest
//class PatientRepositoryTest {
//}
//
//Use for testing repositories and database operations.
//
//4. @TestInstance
//
//Controls how JUnit creates test class objects.
//
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//
//or
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//5. @ExtendWith
//
//Registers extensions such as Mockito or Spring.
//
//@ExtendWith(MockitoExtension.class)
//class ServiceTest {
//}
//
//Used for Mockito-based testing without Spring Boot.
//
//6. @ActiveProfiles
//
//Runs tests with a specific Spring profile.
//
//@ActiveProfiles("test")
//@SpringBootTest
//class PatientServiceTest {
//}
//
//Useful when you have application-test.properties.
//
//7. @AutoConfigureMockMvc
//
//Configures MockMvc in a Spring Boot test.
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class PatientControllerTest {
//}
//
//Allows API testing without starting a real server.
//
//Common Method-Level Annotations
//
//Inside the class, you'll often see:
//
//@BeforeEach
//void setUp() { }
//
//@AfterEach
//void tearDown() { }
//
//@BeforeAll
//static void beforeAll() { }
//
//@AfterAll
//static void afterAll() { }
//
//@Test
//void testMethod() { }
//Most Frequently Used Combination
//
//For a service test:
//
//@SpringBootTest
//class PatientServiceTest {
//}
//
//For a controller test:
//
//@WebMvcTest(PatientController.class)
//class PatientControllerTest {
//}
//
//For a repository test:
//
//@DataJpaTest
//class PatientRepositoryTest {
//}
//
//For a pure JUnit test (no Spring):
//
//@ExtendWith(MockitoExtension.class)
//class TestPracticingClassTest {
//}
//
 //Exactly, Muni. The reason for the NullPointerException is:
//
//@Autowired
//private TestPracticingClass test;
//
//@Autowired only works when Spring creates the test class.
//
//Right now, your test is just:
//
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//class TestPracticingClassTest {
//
//JUnit creates the test class, not Spring.
//As a Spring Boot developer, you'll use @SpringBootTest, @WebMvcTest, @DataJpaTest, @ExtendWith, and @TestInstance most often.
//package org.munivel;
//
//import org.junit.jupiter.api.*;
//        import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Stream;
//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class ProgramTest {
//    private Program program;
//    @BeforeEach
//    void setup(){
//        program=new Program();
//    }
//    @Order(3)
//    @ParameterizedTest
//    @MethodSource("arrayProvider")
//    void testSum(int[] arr, int expected) {
//        int actual = program.missingNum(arr);
//        assertEquals(expected, actual);
//    }
//    @Order(1)
//    @ParameterizedTest
//    @ValueSource(strings = {"Muniveol","sathish"})
//    void test(String name){
//        program.mtring(name);
//    }
//    @Order(2)
//    @ParameterizedTest
//    @CsvSource({"1,2,3,6","3,4,2,9"})
//    void test2(int a,int b , int c,int expected){
//        int actual=program.add(a,b,c);
//        assertEquals(expected, actual);
//    }
//    static Stream<Arguments> arrayProvider() {
//        return Stream.of(
//                Arguments.of(new int[]{1,2,3}, 4),
//                Arguments.of(new int[]{2,3,1},4 ),
//                Arguments.of(new int[]{1},2 )
//        );
//    }
//    @AfterEach
//    void destroy(){
//        program=null;
//    }
//Stream comes from Java Streams API.
//
//    MethodSource → provides test data
//    ParameterizedTest → runs multiple times
//    BeforeEach → object creation
//    Test Method → logic testing
//    AfterEach → cleanup
//It creates a stream (collection) of data that JUnit will read.
//
//Example idea:
//
//Stream → [test data 1, test data 2, test data 3]
//
//Here we are giving two test cases.
//    //Arguments.of(new int[]{1,2,3}, 6)
//    //
//    //Arguments.of() creates one set of parameters for the test method.
//Actual Execution Order
//
//When JUnit sees:
//
//@ParameterizedTest
//@MethodSource("arrayProvider")
//
//it must first get the test data, otherwise it doesn’t know how many times to run the test.
//
//So the order is:
//
//1. Call arrayProvider()  → get test data
//2. Create test iteration
//3. Run @BeforeEach
//4. Run test method
//5. Run @AfterEach
//6. Repeat for next data
//📊 Workflow Diagram
//JUnit starts test class
//        │
//        ▼
//Calls arrayProvider()
//(get test data)
//        │
//        ▼
//Stream<Arguments>
// ├── Arguments([1,2,3],6)
// └── Arguments([4,5,6],15)
//        │
//        ▼
//Iteration 1
//   │
//   ▼
//@BeforeEach → setup()
//   │
//   ▼
//testSum([1,2,3],6)
//   │
//   ▼
//@AfterEach → destroy()
//
//        │
//        ▼
//Iteration 2
//   │
//   ▼
//@BeforeEach → setup()
//   │
//   ▼
//testSum([4,5,6],15)
//   │
//   ▼
//@AfterEach → destroy()
//🧠 Key Concept
//
//@MethodSource must run before @BeforeEach because JUnit needs to prepare the test parameters first.
//
//Think of it like this:
//
//Step 1 → Collect test inputs
//Step 2 → Run setup
//Step 3 → Execute test
//Step 4 → Cleanup

    //Start Test Execution
    //        │
    //        ▼
    //JUnit loads ProgramTest class
    //        │
    //        ▼
    //@TestInstance(PER_CLASS)
    //→ One instance of test class is created
    //        │
    //        ▼
    //JUnit finds @ParameterizedTest
    //        │
    //        ▼
    //@MethodSource("arrayProvider") is called
    //        │
    //        ▼
    //arrayProvider() method executes
    //        │
    //        ▼
    //Returns Stream<Arguments>
    //        │
    //        ▼
    //Stream contains test cases
    // ├── Arguments([1,2,3],6)
    // └── Arguments([4,5,6],15)
    //        │
    //        ▼
    //JUnit starts first test iteration
    //        │
    //        ▼
    //@BeforeEach runs
    //setup()
    //program = new Program()
    //        │
    //        ▼
    //testSum([1,2,3],6) runs
    //        │
    //        ▼
    //program.missingNum([1,2,3])
    //        │
    //        ▼
    //assertEquals(expected, actual)
    //        │
    //        ▼
    //@AfterEach runs
    //destroy()
    //program = null
    //        │
    //        ▼
    //JUnit starts second test iteration
    //        │
    //        ▼
    //@BeforeEach runs again
    //setup()
    //program = new Program()
    //        │
    //        ▼
    //testSum([4,5,6],15)
    //        │
    //        ▼
    //Assertion check
    //        │
    //        ▼
    //@AfterEach runs
    //destroy()
    //        │
    //        ▼
    //All test cases finished
    //        │
    //        ▼
    //Test Execution Complete





//    @BeforeAll
//    static  void setup(){
//        System.out.println("Object is declared ");
//    }

//int arr[]={1,2,3,4,5};
//ArrayList<Integer> arrayList=program.getMinMax(arr);
//
//
//    @Order(3)
//    @RepeatedTest(5)
//    void t1(){
//        assertEquals(1,arrayList.get(0));
//        assertEquals(4,arrayList.get(1));
//        System.out.println(arrayList.get(0)+" "+arrayList.get(1));
//    }
//
    //Internally (conceptually)
//
//JUnit does something like this:
//If the value is different
//
//Example:
//
//int actual = program.add(3,4,2);
//assertEquals(6, actual);
//
//Now:
//
//expected = 6
//actual   = 9
//
//JUnit result:
//
//Test Failed
//Expected: 6
//Actual  : 9
//
//So JUnit tells you your program logic is wrong.

//if(expected.equals(actual)){
//    testPassed();
//}else{
//    testFailed();
//}
//Why we use expected first
//
//The order is important:
//
//assertEquals(expected, actual)


    //Single input → ValueSource
    //Multiple inputs → CsvSource
    //Complex data / arrays → MethodSource
    //Annotation	When
    //@ValueSource	one parameter
    //@CsvSource	multiple simple parameters
    //@MethodSource	arrays / objects / complex data
    // @MethodSource supplies test data to a parameterized test from a method.

//    @Order(1)

//    @Test
//    @Order(1)
//    void test3(){
//        assertTrue(arrayList.get(0)==1);
//        System.out.println("Test 3");
//    }

//    @BeforeEach
//    void setups(){
//        program=new Program();
//    }
//
//   @Test
//    void test1(){
//       assertTrue(program.armstrong(371)==true);
//   }
//
//    @Test
//    void test2(){
//        assertTrue(program.armstrong(372)==false);
//    }


//    @Test
//    @Order(1)
//    void add(){
//       program.add(1,4);
//        System.out.println(program.result);
//    }

//    @Test
//    @Order(2)
//    void add1(){
//        System.out.println(program.result);
//    }
//    @Test
//    @Order(3)
//    void test3() {
//        List<Integer> result = program.printDivisors(16);
//
//        List<Integer> expected = Arrays.asList(1, 2, 4, 8, 16);
//
//        assertEquals(expected, result);
//    }
//    @Test
//    @Order(3)
//    void test4() {
//        List<Integer> result = program.printDivisors(5);
//
//        List<Integer> expected = Arrays.asList(1, 5);
//
//        assertEquals(expected, result);
//    }
////
//@AfterEach
//    void Destroy(){
//        program=null;

//Annotation	Purpose
//    @ValueSource	Single parameter
//    @CsvSource	Multiple parameters
//    @MethodSource	Complex data
//}
