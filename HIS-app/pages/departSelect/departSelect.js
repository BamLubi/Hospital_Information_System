// pages/departSelect.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    departInfoList: [],
    registerType: "0"
  },
  onTypeChange(event) {
    this.setData({
      registerType: event.detail,
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.request({
      url: 'http://localhost:7777/wx/global/depart/all',
      method: 'GET',
      header: {
        'content-type': 'application/json;charset=utf8' //默认值
      },
      success: (res) => {
        this.setData({
          departInfoList: res.data.data
        })
        // console.log(this.data.departInfoList)
      }
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

  }
})