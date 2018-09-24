package com.music.config;

import static junit.framework.TestCase.assertNotNull;

import com.mymusic.config.SwaggerConfig;
import org.junit.Before;
import org.junit.Test;

public class SwaggerConfigTest {
  private SwaggerConfig swaggerConfig;

  @Before
  public void setUp(){
    this.swaggerConfig = new SwaggerConfig();
  }

  @Test
  public void testPostsApi(){
    assertNotNull(this.swaggerConfig.postsApi());
  }
}
