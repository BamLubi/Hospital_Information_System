// pages/doctorSelect/doctorSelect.js
const app = getApp();
const utils = require("../../utils/util")
const API = require("../../promise/wxAPI")
Page({


  /**
   * 页面的初始数据
   */
  data: {
    departId: '', // 部门号
    registerType: "", // 等级
    dateList: [],
    scheduleList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    that.setData({
      departId: options.departId,
      registerType: options.registerType,
      dateList: utils.getfutureFiveDays()
    })
    console.log("[七天日期] : ", that.data.dateList)
    // 默认刷新第一个天气
    let event = {
      target: {
        dataset: {
          datetime: that.data.dateList[0].dateTime
        }
      }
    }
    that.selectDate(event)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 选择医生,预约
   */
  selectDoctor(event) {
    if (app.globalData.hasPatientInfo == false) {
      API.ShowToast('请先创建就诊卡！', 'none', 2000)
    } else {
      // 新增挂号
      let payLoad = {
        registerFee: event.currentTarget.dataset.registerfee,
        patientInfo: {
          id: app.globalData.patientInfo.id
        },
        doctor: {
          id: event.currentTarget.dataset.doctorid
        },
        departInfo: {
          id: event.currentTarget.dataset.departid
        }
      };
      let url = 'http://localhost:7777/wx/charge/register'
      API.Request(url, 'PUT', payLoad, '新增挂号').then(res => {
        return API.ShowToast('预约成功', 'success', 2000)
      }).catch(err => {
        return API.ShowToast('预约失败', 'success', 2000)
      })
    }
  },

  /**
   * 选择日期,显示当日的可用医生
   * @param {*} event 
   */
  selectDate(event) {
    var that = this
    // 初始化数组
    that.setData({
      scheduleList: []
    })
    // 获取选中时间
    let dateTime = event.target.dataset.datetime.split(" ")[0];
    // 获取改时间有空的医生
    let url = 'http://localhost:7777/wx/charge/schedule'
    let data = {
      scheduleDate: dateTime,
      level: this.data.registerType,
      departInfo: {
        id: this.data.departId
      }
    }
    console.log(data)
    API.Request(url, 'POST', data, '获取选中日期所有医生').then(res => {
      that.setData({
        scheduleList: res.data.data
      })
    })
  },
})