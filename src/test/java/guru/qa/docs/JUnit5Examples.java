package guru.qa.docs;

import org.junit.jupiter.api.*;


public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests!\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests!\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before test!\n");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After test!\n");
    }

    @Test
    void firstTest() {
        System.out.println("I love you QA.GURU\n");
    }

    @Test
    void secondTest() {
        System.out.println("I love you QA.GURU, second test!\n");
    }
}
