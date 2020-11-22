package service.Impl;

import service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Override
    public int calculate(int num) {
        return num*23000;
    }
}
