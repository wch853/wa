package com.njfu.wa.sys.mapper;

import com.njfu.wa.sys.domain.Field;
import com.njfu.wa.sys.domain.Sensor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SensorMapperTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SensorMapper sensorMapper;

    @Test
    public void selectSensors() throws Exception {
        Sensor sensor = new Sensor();
        sensor.setField(new Field());

        List<Sensor> sensors = sensorMapper.selectSensors(sensor);

        log.info("sensors: {}", sensors);
    }

    @Test
    public void insertSensor() throws Exception {
        Sensor sensor = new Sensor();
        sensor.setSensorId("s-01-000");
        sensor.setSensorFunc("1");
        sensor.setSensorType("aaa001");
        sensor.setField(new Field());
        sensor.setUseStatus("0");
        sensor.setSensorPs("test");

        int res = sensorMapper.insertSensor(sensor);

        Assert.assertEquals(1, res);
    }

    @Test
    public void updateSensor() throws Exception {
        Sensor sensor = new Sensor();
        sensor.setSensorId("s-01-001");
        sensor.setSensorFunc("1");
        sensor.setSensorType("aaa001");
        sensor.setField(new Field());
        sensor.setUseStatus("0");
        sensor.setSensorPs("test");

        int res = sensorMapper.updateSensor(sensor);

        Assert.assertEquals(1, res);
    }

    @Test
    public void deleteSensor() throws Exception {
        Sensor sensor = new Sensor();
        sensor.setSensorId("s-01-001");

        int res = sensorMapper.deleteSensor(sensor);

        Assert.assertEquals(1, res);
    }

}