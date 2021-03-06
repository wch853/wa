package com.njfu.ia.sys.service.impl;

import com.njfu.ia.sys.domain.Block;
import com.njfu.ia.sys.domain.Machine;
import com.njfu.ia.sys.exception.BusinessException;
import com.njfu.ia.sys.mapper.MachineMapper;
import com.njfu.ia.sys.service.MachineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    @Resource
    private MachineMapper machineMapper;

    /**
     * 获取机械列表
     *
     * @param machine
     * @param block
     * @return data
     */
    @Override
    public List<Machine> queryMachines(Machine machine, Block block) {
        machine.setBlock(block);
        return machineMapper.selectMachines(machine);
    }

    /**
     * 新增机械信息
     *
     * @param machine
     * @param block
     */
    @Override
    public void addMachine(Machine machine, Block block) {
        this.convertNull(machine, block);
        int res = machineMapper.insertMachine(machine);
        if (res <= 0) {
            throw new BusinessException("新增机械信息失败，请检查新增编号是否存在！");
        }
    }

    /**
     * 修改机械信息
     *
     * @param machine
     * @param block
     */
    @Override
    public void modifyMachine(Machine machine, Block block) {
        this.convertNull(machine, block);
        int res = machineMapper.updateMachine(machine);
        if (res <= 0) {
            throw new BusinessException("修改机械信息失败！");
        }
    }

    /**
     * 删除机械信息
     *
     * @param machine
     */
    @Override
    public void removeMachine(Machine machine) {
        int res = machineMapper.deleteMachine(machine);
        if (res <= 0) {
            throw new BusinessException("删除机械信息失败！");
        }
    }

    /**
     * 若machinePs、blockId为空字符串，转为null
     *
     * @param machine
     * @param block
     */
    private void convertNull(Machine machine, Block block) {
        if ("".equals(machine.getMachinePs())) {
            machine.setMachinePs(null);
        }

    }
}
