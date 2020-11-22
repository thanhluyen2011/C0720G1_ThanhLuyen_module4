package service.Impl;

import org.springframework.stereotype.Service;
import service.DictionaryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Override
    public String dictionary(String data) {
        String thongtin = null;
        Map<String,String> map = new HashMap();
        map.put("sach","book");
        map.put("ban","table");
        map.put("but chi","pencil");
        map.put("cuc tay","lump");
        map.put("but","pen");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (data.equals(entry.getKey())){
                thongtin = entry.getValue();
                break;
            }
        }
        if (thongtin == null){
            thongtin = "Từ Điển Không Đủ Thông tin";
        }
        return  thongtin;
    }
}
