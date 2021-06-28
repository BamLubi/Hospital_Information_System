// pages/todaySelect/todaySelect.js
const API = require("../../promise/wxAPI")
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    scheduleList: [{
      doctor: {
        id: '1',
        doctorRanker: '主任医师',
        name: '测试医生',
        departInfo: {
          id: '1'
        }
      },
      level: '0',
      remainAm: '50',
      remainPm: '50'
    }],

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 获取所有今日医生数据
    let url = 'http://localhost:7777/wx/charge/schedule'
    let data = {
      scheduleDate: "2021-04-25",
      departInfo: {
        id: ""
      },
      level: ""
    }
    API.Request(url, 'POST', data, '获取今日所有医生').then(res => {
      this.setData({
        scheduleList: res.data.data
      })
    })
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
   * 预约 
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
  }
})