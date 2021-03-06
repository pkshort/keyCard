package edu.ithaca.group1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User myUser;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myUser = new User();
    }

    @org.junit.jupiter.api.Test
    void setId() {
        String myId = "4";
        myUser.setId("4");
        assertEquals(myId, myUser.getId());

        String myId2 = "";
        myUser.setId(myId2);
        assertEquals(myId2, myUser.getId());

    }

    @org.junit.jupiter.api.Test
    void getId() {
        String myId = "6";
        myUser.setId("6");
        assertEquals(myId, myUser.getId());

        String myId2 = "0";
        myUser.setId("0");
        assertEquals(myId2, myUser.getId());

    }

    @org.junit.jupiter.api.Test
    void setName() {
        String myName = "Jeff";
        myUser.setName(myName);
        assertEquals(myName, myUser.getName());

        String myName2 = "";
        myUser.setName(myName2);
        assertEquals(myName2, myUser.getName());

    }

    @org.junit.jupiter.api.Test
    void getName() {
        String myName = "Ray";
        myUser.setName(myName);
        assertEquals(myName, myUser.getName());

        String myName2 = "";
        myUser.setName(myName2);
        assertEquals(myName2, myUser.getName());
    }


    @org.junit.jupiter.api.Test
    void getDepartment() {
        String myDept = "Comp Sci";
        myUser.setDepartment(myDept);
        assertEquals(myDept, myUser.getDepartment(), "Department does not match");
    }

    @org.junit.jupiter.api.Test
    void setDepartment() {
        String myDept = "Comp Sci";
        myUser.setDepartment(myDept);
        assertEquals(myDept, myUser.getDepartment(), "Department does not match");

        myDept = "";
        myUser.setDepartment(myDept);
        assertEquals(myDept, myUser.getDepartment(), "Department does not match");
    }
}