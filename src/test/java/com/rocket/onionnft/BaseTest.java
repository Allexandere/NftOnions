package com.rocket.onionnft;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@Import(PostgreTestConfig.class)
@ContextConfiguration(classes = PostgreTestConfig.class)
public class BaseTest {
}
