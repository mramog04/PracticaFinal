package es.unileon.prg2.patterns.iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unileon.prg2.patterns.composite.ElectoralSchool;
import es.unileon.prg2.patterns.composite.ElectoralComponent;
import es.unileon.prg2.patterns.handler.GenericId;

public class QueueIteratorTests {

    private QueueIterator<ElectoralComponent> queueIterator;
    private Aggregate<ElectoralComponent> aggregate;
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
	
		this.queueIterator = new QueueIterator<ElectoralComponent>(this.aggregate);
	}

    @Test
    void testCurrentElement() {
        assertSame(eva, this.queueIterator.currentElement());
        this.queueIterator.nextElement();
        assertSame(pedro, this.queueIterator.currentElement());
    }

    @Test
    void testFirstElement() {
        assertSame(eva, this.queueIterator.currentElement());
        this.queueIterator.nextElement();
        assertSame(pedro, this.queueIterator.currentElement());
        this.queueIterator.firstElement();
        assertSame(eva, this.queueIterator.currentElement());
    }

    @Test
    void testHasMoreElements() {
        assertTrue(this.queueIterator.hasMoreElements());
        this.queueIterator.nextElement();
        assertTrue(this.queueIterator.hasMoreElements());
        this.queueIterator.nextElement();
        assertTrue(this.queueIterator.hasMoreElements());
        this.queueIterator.nextElement();
        assertTrue(this.queueIterator.hasMoreElements());
        this.queueIterator.nextElement();
        assertFalse(this.queueIterator.hasMoreElements());
    }

    @Test
    void testNextElement() {
        assertSame(eva, this.queueIterator.currentElement());
        this.queueIterator.nextElement();
        assertSame(pedro, this.queueIterator.currentElement());
    }
}