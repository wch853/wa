package com.njfu.wa.sys.service.impl;

import com.njfu.wa.sys.domain.Crop;
import com.njfu.wa.sys.domain.util.Result;
import com.njfu.wa.sys.domain.util.ResultFactory;
import com.njfu.wa.sys.mapper.CropMapper;
import com.njfu.wa.sys.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {

    @Autowired
    private CropMapper cropMapper;

    @Autowired
    private ResultFactory resultFactory;

    /**
     * 获取作物列表
     *
     * @param crop cropId cropName
     * @return data
     */
    @Override
    public List<Crop> getCrops(Crop crop) {
        return cropMapper.selectCrops(crop);
    }

    /**
     * 新增作物信息
     *
     * @param crop cropId cropName cropPs
     * @return message
     */
    @Override
    public Result addCrop(Crop crop) {
        if ("".equals(crop.getCropPs())) {
            crop.setCropPs(null);
        }

        int res = cropMapper.insertCrop(crop);

        if (res == 0) {
            return resultFactory.failMessage("新增作物信息失败，请检查新增编号是否存在！");
        }

        return resultFactory.successMessage("新增作物信息成功！");
    }

    /**
     * 修改作物信息
     *
     * @param crop cropId cropName cropPs
     * @return message
     */
    @Override
    public Result modifyCrop(Crop crop) {
        if ("".equals(crop.getCropPs())) {
            crop.setCropPs(null);
        }

        int res = cropMapper.updateCrop(crop);

        if (res == 0) {
            return resultFactory.failMessage("修改作物信息失败!");
        }

        return resultFactory.successMessage("修改作物信息成功!");
    }

    /**
     * 删除作物信息
     *
     * @param crop cropId
     * @return message
     */
    @Override
    public Result removeCrop(Crop crop) {
        int res = cropMapper.deleteCrop(crop);

        if (res == 0) {
            return resultFactory.failMessage("删除作物信息失败!");
        }

        return resultFactory.successMessage("删除作物信息成功!");
    }
}
