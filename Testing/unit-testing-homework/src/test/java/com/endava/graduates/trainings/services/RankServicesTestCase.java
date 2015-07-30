package com.endava.graduates.trainings.services;

import com.endava.graduates.trainings.file.StubFileRead;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rursu on 7/30/2015.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(RankService.class)
public class RankServicesTestCase {
    @InjectMocks
    RankService rankService;

    @Before
    public void setUp() throws Exception {
        rankService = new RankService();
    }

    @Test
    public void testFileRead() throws Exception {
        rankService = new RankService();
        assertTrue(rankService.obtaintRankFromFile(new StubFileRead()));
    }
}
