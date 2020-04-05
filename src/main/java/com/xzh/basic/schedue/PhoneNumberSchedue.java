package com.xzh.basic.schedue;

import com.alibaba.fastjson.JSONObject;
import com.xzh.basic.dao.mapper.PhoneNumberMapper;
import com.xzh.basic.dao.pojo.PhoneNumber;
import com.xzh.basic.model.MobileRes;
import com.xzh.basic.model.Number;
import com.xzh.basic.utils.HttpUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PhoneNumberSchedue {

    @Resource
    private PhoneNumberMapper phoneNumberMapper;

    @Scheduled(cron = "0 * * * * ?")
    public void getPhoneNumber() {
        get();
    }

    private void get() {
        String[] topics = {"5", "1", "2", "3"};
        for (String topic : topics) {
            save(topic);
        }
    }

    private void save(String topic) {
        Set<String> phones = find(topic);
        if (CollectionUtils.isEmpty(phones)){
            return;
        }
        for (String phone : phones) {
            List<PhoneNumber> select = phoneNumberMapper.select(new PhoneNumber(phone));
            if (CollectionUtils.isEmpty(select)){
                phoneNumberMapper.insertSelective(new PhoneNumber(phone, phone.substring(7,11), topic));
            }
        }
    }

    private Set<String> find(String topic){
        Set<String> set = new HashSet<>();
        String url = "https://rwk.cmicrwx.cn/rwx/rwkweb/livehk/opt/select-number";
        JSONObject json = new JSONObject();
        json.put("MsgType","LivehkOptimizationNumReq");
        json.put("Version","1.0.0");
        json.put("accessToken","LIVEHK_ACCESSTOKEN_C10000033729_73236BA53999118D8617DF3BDF8FCB33_43");
        json.put("count","8");
        json.put("provCode","270");
        json.put("searchKey","");
        json.put("topic", topic);
        String s = HttpUtils.postJsonHttpClient(url, json.toJSONString());
        MobileRes mobileRes = JSONObject.parseObject(s, MobileRes.class);
        List<Number> numbers = mobileRes.getNumbers();
        for (Number number : numbers) {
            if (number.getNumber().contains("4")){
                continue;
            }
            if (!number.getCityId().equals("270")){
                continue;
            }
            set.add(number.getNumber());
        }
        return set;
    }
}
