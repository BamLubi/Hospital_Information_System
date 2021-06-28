// pages/userMange/userManage.js
//获取应用实例
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {},
    hasUserInfo: false,
    patientInfo: {},
    hasPatientInfo: false,
    activeTag: "/pages/userManage/userManage"
  },
  onTagChange: function (e) {
    this.setData({
      activeTag: e.detail
    });
    console.log(e.detail)
    wx.navigateTo({
      url: e.detail
    })
  },
  openPatientManagePage: function (e) {
    wx.navigateTo({
      url: "/pages/patientManage/patientManage"
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (optoins) {
    // 异步获取个人信息
    if (app.globalData.hasUserInfo) {
      this.setData({
        userInfo: app.globalData.localUserInfo,
        hasUserInfo: true,
      })
    } else {
      // 异步操作
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: app.globalData.localUserInfo,
          hasUserInfo: true,
        })
      }
    }
    // 异步获取病人信息
    if (app.globalData.hasPatientInfo) {
      this.setData({
        patientInfo: app.globalData.patientInfo,
        hasPatientInfo: true,
      })
    } else {
      // 异步操作
      app.patientInfoReadyCallback = res => {
        this.setData({
          patientInfo: app.globalData.patientInfo,
          hasPatientInfo: true,
        })
      }
    }
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
   * 授权
   */
  getUserInfo: function (e) {
    if (e.detail.userInfo) {
      app.getUserInfo()
    }
  },
})