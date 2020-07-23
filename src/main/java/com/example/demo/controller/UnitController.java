package com.example.demo.controller;

import com.example.demo.entity.UnitEntity;
import com.example.demo.mapper.UnitMapper;
import com.example.demo.utils.Pinyin4jUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unit")
public class UnitController {

    @Resource
    private UnitMapper unitMapper;

    @RequestMapping("/list")
    @ResponseBody
    public Object findByNameLike(){
        List<UnitEntity> unitList=unitMapper.findAll();
        for (UnitEntity unit:unitList){
            String simpleSpell=Pinyin4jUtil.getFirstSpellPinYin(unit.getNAME(),false).toUpperCase().toString();
            unit.setFirstChar(simpleSpell.substring(0, 1));
        }
        //按首字母排序
        Map<String, List<UnitEntity>> units = unitList.stream()
                .collect(Collectors.groupingBy(UnitEntity::getFirstChar));

        return units;
    }

    @RequestMapping("/dictionaries")
    @ResponseBody
    public Object getDictionaries(){
        List<UnitEntity> units=unitMapper.findAll();
        List<Map> dictionaries=new ArrayList<Map>();
        for (UnitEntity unit:units){
            Map result = new HashMap();
            result.put("id",unit.getID());
            result.put("name",unit.getNAME());
            Set<String> result1= Pinyin4jUtil.getPinyin(unit.getNAME(),true);//全拼
            for (String temp:result1){
                result.put("fullSpell",temp);
                dictionaries.add(result);
            }
            Set<String> result2= Pinyin4jUtil.getPinyin(unit.getNAME(),false);//简拼
            for (String temp:result2){
                result.put("simpleSpell",temp);
                dictionaries.add(result);
            }
        }
        return dictionaries;
    }
}