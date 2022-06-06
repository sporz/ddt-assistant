package cn.xiejx.ddtassistant.controller;

import cn.xiejx.ddtassistant.type.auction.AuctionData;
import cn.xiejx.ddtassistant.logic.AuctionLogic;
import cn.xiejx.ddtassistant.vo.MyString;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2022/06/04 19:32
 */
@RestController
public class AuctionController {
    @Resource
    private AuctionLogic auctionLogic;

    @RequestMapping("/auction/getList")
    public AuctionData getAuctionData() {
        return auctionLogic.getAuctionData();
    }

    @RequestMapping("/auction/update")
    public Boolean update(@RequestBody AuctionData auctionData) {
        auctionLogic.updateAuctionData(auctionData);
        return true;
    }

    @RequestMapping("/auction/bindAndSell")
    public Boolean bindAndSell(int hwnd) {
        return auctionLogic.bindAndSell(hwnd);
    }

    @RequestMapping("/auction/bindAndSellAll")
    public MyString bindAndSell(Integer[] hwnds) {
        return new MyString(auctionLogic.bindAndSellAll(hwnds));
    }

    @RequestMapping("/auction/stop")
    public Boolean stop(int hwnd) {
        return auctionLogic.stop(hwnd);
    }

    @RequestMapping("/auction/stopAll")
    public Integer stopAll() {
        return auctionLogic.stopAll();
    }
}
