//app.js
const API = require("./promise/wxAPI.js")
App({
  onLaunch: function () {
    var that = this
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 获取用户信息
    that.getUserInfo()
  },

  /**
   * 获取用户信息
   */
  getUserInfo: function () {
    var that = this
    // 判断用户是否授权
    API.GetSetting().then(res => {
      // 获取用户信息
      return API.GetUserInfo()
    }).then(res => {
      that.globalData.userInfo = res.userInfo
      that.globalData.hasUserInfo = true
      // 回调广播函数
      if (that.userInfoReadyCallback) {
        that.userInfoReadyCallback(res)
      }
      let url = 'http://localhost:7777/wx/charge/patient/' + res.userInfo.nickName
      return API.Request(url, 'GET', '', '获取病人信息')
    }).then(res => {
      if (res.data.data && res.data.data.id) {
        that.globalData.patientInfo = res.data.data
        that.globalData.hasPatientInfo = true
      } else {
        that.globalData.patientInfo = {}
      }
      // 回调广播函数
      if (that.patientInfoReadyCallback) {
        that.patientInfoReadyCallback(res)
      }
    })
  },
  globalData: {
    userInfo: null,
    hasUserInfo: false,
    patientInfo: null,
    hasPatientInfo: false
  }
})