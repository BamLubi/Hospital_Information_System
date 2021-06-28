// pages/patientManage/patientManage.js、
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    patientInfo: {},
    newInfo: {
      name: "",
      phoneNum: "",
      gender: "m",
      age: "",
      wxAccount: "",
      identity: ""
    },
    genders: [{
      key: 'm',
      val: '男'
    }, {
      key: 'f',
      val: '女'
    }],
    "default-gender": 0
  },

  submitPatient(e) {
    this.data.newInfo.wxAccount = app.globalData.userInfo.nickName
    console.log(this.data.newInfo);
    wx.request({
      url: "http://localhost:7777/wx/charge/patient/save",
      method: 'POST',
      header: {
        'content-type': 'application/json;charset=utf8' //默认值
      },
      data: this.data.newInfo,
      success: res => {
        if (res.data.code == 20000) {
          wx.showToast({
            title: '保存成功',
            icon: 'success',
            duration: 2000
          })
          app.globalData.patientInfo = this.data.newInfo;
          wx.navigateTo({
            url: '/pages/userManage/userManage',
          })
        } else {
          wx.showToast({
            title: '保存失败',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
  },

  onNameChange(e) {
    this.setData({
      ["newInfo.name"] : e.detail
    })
  },

  onPhoneNumChange(e) {
    this.setData({
      ["newInfo.phoneNum"] : e.detail
    })
  },

  onGenderChange(e) {
    console.log("性别", e)
    this.setData({
      ["newInfo.gender"] : e.detail.value.key
    })
  },

  onIdentityChange(e) {
    this.setData({
      ["newInfo.identity"] : e.detail
    })
  },

  onAgeChange(e) {
    this.setData({
      ["newInfo.age"] : e.detail
    })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 从全局获取病人信息
    var dg = 0;
    if (app.globalData.patientInfo === '男') {
      dg = 0;
    } else {
      dg = 1;
    }
    this.setData({
      patientInfo: app.globalData.patientInfo,
      newInfo: app.globalData.patientInfo,
      "default-gender": dg
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