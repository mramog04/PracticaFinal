package es.unileon.prg2.patterns.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.annotation.ElementType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.composite.ElectoralSchool;
import es.unileon.prg2.patterns.composite.ElectoralComponent;
import es.unileon.prg2.patterns.composite.ElectoralComposite;
import es.unileon.prg2.patterns.handler.GenericId;

public class VectorAggregateTests {

    private VectorAggregate<ElectoralComponent> aggregate;
    private ElectoralComponent ana, juan, pedro, eva;

    @BeforeEach
    void setUp() throws Exception {
        // aggregate is not a composite pattern
        this.aggregate = new VectorAggregate<ElectoralComponent>();
        this.ana = new ElectoralSchool(new GenericId("Ana"));
        this.juan = new ElectoralSchool(new GenericId("Juan"));
        this.pedro = new ElectoralSchool(new GenericId("Pedro"));
        this.eva = new ElectoralSchool(new GenericId("Eva"));

        this.aggregate.add(ana);
        this.aggregate.add(juan);
        this.aggregate.add(pedro);
        this.aggregate.add(eva);

     }

    @Test
    void testCreateIterator() {
        Iterator<ElectoralComponent> listIterator;
        listIterator = this.aggregate.createIterator();
        assertSame(ana, listIterator.currentElement());
    }

    @Test
    void testCreateIterator2() {
        Iterator<ElectoralComponent> queueIterator;
        queueIterator = this.aggregate.createIterator("queue");
        assertSame(eva, queueIterator.currentElement());
    }

    @Test
    void testGetElement() {
        assertSame(ana, this.aggregate.get(0));
        this.aggregate.remove(0);
        assertSame(juan, this.aggregate.get(0));
    }

    @Test
    void testGetSize() {
        assertEquals(4, this.aggregate.getSize());
        this.aggregate.remove(0);
        assertEquals(3, this.aggregate.getSize());
    }

    @Test
    void testRemoveElement() {
        assertEquals(4, this.aggregate.getSize());
        assertSame(ana, this.aggregate.get(0));
        this.aggregate.remove(0);
        assertEquals(3, this.aggregate.getSize());
        assertSame(juan, this.aggregate.get(0));
    }

}
