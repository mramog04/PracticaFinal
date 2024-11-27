package es.unileon.prg2.patterns.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.iterator.Iterator;

public class CitizenTests {

    private ElectoralSchool ana, juan;

    @BeforeEach
    void setUp() throws Exception {
        this.ana = new ElectoralSchool("Ana");
        this.juan = new ElectoralSchool("Juan");
    }

    @Test
    void testGetId() {
        assertEquals("Ana", this.ana.getId().toString());
    }

    @Test
    void testGetLevel() {
        assertEquals(Levels.ELECTORALSCHOOL, this.ana.getLevel());
    }

    @Test
    void testAdd() {
        Exception exception = assertThrows(CompositeException.class, () -> this.ana.add(this.juan));
        assertEquals("Nothing can be added to a leaf",
                exception.getMessage());
    }

    @Test
    void testRemove() {
        assertFalse(this.ana.remove(this.juan));
    }

    @Test
    void testSearchOk() {
        assertSame(this.ana, this.ana.search(new Name("Ana")));
    }

    @Test
    void testSearchNotOk() {
        assertNull(this.ana.search(new Name("Juan")));
    }

    @Test
    void testSize() {
        assertEquals(1, this.ana.size());
    }

    @Test
    void testToString() {
        assertEquals("\t\t\t\t\t\t\tElectoralSchool: Ana\n", this.ana.toString());
    }

    @Test
    void testCreateIterator(){
        Iterator<ElectoralComponent> iterator = this.ana.createIterator();
        assertNull(iterator.currentElement());
    }

    @Test
    void testCreateIteratorString(){
        Iterator<ElectoralComponent> iterator = this.ana.createIterator("whatever");
        assertNull(iterator.currentElement());
    }

}