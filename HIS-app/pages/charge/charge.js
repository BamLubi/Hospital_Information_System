// pages/charge/charge.js
const app = getApp();
const utils = require("../../utils/util")
const API = require("../../promise/wxAPI")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    registerData: {},
    hasRegisterData: false,
    presData: {},
    hasPresData: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    // 获取挂号与处方
    let name = app.globalData.patientInfo.name
    let url = 'http://localhost:7777/doctor/register'
    let data = {
      patientInfo: {
        name: name
      }
    }
    API.Request(url, 'POST', data, '获取挂号').then(res => {
      if (res.data.data == null) {
        // 没有数据
        that.setData({
          hasRegisterData: false
        })
      } else {
        that.setData({
          registerData: res.data.data,
          hasRegisterData: true
        })
        // 查询处方
        let re_id = res.data.data.id
        let url = 'http://localhost:7777/doctor/pres/find'
        let data = {
          registerInfo: {
            id: re_id
          }
        }
        return API.Request(url, 'POST', data, '查询处方')
      }
    }).then(res => {
      console.log(res.data)
      if (res.data.data == null) {
        // 没有数据
        that.setData({
          hasPresData: false
        })
      } else {
        that.setData({
          presData: res.data.data,
          hasPresData: true
        })
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

  },

  /**
   * 挂号交费
   */
  chargeRegister: function () {
    var that = this
    let id = that.data.registerData.id
    let price = that.data.registerData.registerFee
    // 提示框
    API.ShowModal('挂号交费', '交费金额: ' + price + '元', true, '取消', '确定').then(
      function (res) {
        // 交费
        let url = 'http://localhost:7777/charge/register'
        let data = {
          id: id
        }
        return API.Request(url, 'PUT', data, '挂号交费')
      }
    ).then(res => {
      return API.ShowToast('交费成功', 'success', 2000)
    }).then(res => {
      that.onLoad()
    })
  },

   /**
   * 处方交费
   */
  chargePres: function () {
    var that = this
    let id = that.data.presData.id
    let price = that.data.presData.drugFee
    // 提示框
    API.ShowModal('挂号交费', '交费金额: ' + price + '元', true, '取消', '确定').then(
      function (res) {
        // 交费
        let url = 'http://localhost:7777/charge/pres'
        let data = {
          id: id,
          presStatus: '2'
        }
        return API.Request(url, 'PUT', data, '处方交费')
      }
    ).then(res => {
      return API.ShowToast('交费成功', 'success', 2000)
    }).then(res => {
      that.onLoad()
    })
  }
})