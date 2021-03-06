package com.njfu.ia.sys.mapper;

import com.njfu.ia.sys.domain.Crop;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CropMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CropMapperTest.class);

    @Resource
    private CropMapper cropMapper;

    @Test
    public void selectCrops() throws Exception {
        List<Crop> crops = cropMapper.selectCrops(new Crop());
        LOGGER.info("crops: {}", crops);
    }

    @Test
    public void insertCrop() throws Exception {
        Crop crop = new Crop();
        crop.setCropName("test");

        int res = cropMapper.insertCrop(crop);
        Assert.assertEquals(1, res);
    }

    @Test
    public void updateCrop() throws Exception {
        Crop crop = new Crop();
        crop.setCropName("test");

        int res = cropMapper.updateCrop(crop);
        Assert.assertEquals(1, res);
    }

    @Test
    public void deleteCrop() throws Exception {
        Crop crop = new Crop();

        int res = cropMapper.deleteCrop(crop);
        Assert.assertEquals(1, res);
    }

}