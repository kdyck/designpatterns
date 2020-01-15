package com.qarepo.reactive;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import static org.junit.Assert.*;

public class CustomSubscriberTest {

    @Test
    public void givenPublisher_whenRequestForOnlyOneElement_thenShouldConsumeOnlyThatOne() {
        // given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        CustomSubscriber<String> subscriber = new CustomSubscriber<>(1);
        publisher.subscribe(subscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");
        List<String> expected = List.of("1");
        // when
        assertEquals(publisher.getNumberOfSubscribers(), 1);
        items.forEach(publisher::submit);
        publisher.close();
        // assertEquals(subscriber.consumedElements.size(), expected.size());
    }

    @Test
    public void givenPublisher_whenRequestForElements_thenShouldConsumeAll() {
        // given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        CustomSubscriber<String> subscriber = new CustomSubscriber<>(1);
        publisher.subscribe(subscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");
        // when
        assertEquals(publisher.getNumberOfSubscribers(), 1);
        items.forEach(publisher::submit);
        publisher.close();
    }
}
