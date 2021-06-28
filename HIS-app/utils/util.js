const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('-') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}
const dayTimeStamp = 24 * 60 * 60 * 1000;
const weekdays = [{
    value: 0,
    str: "周日"
  },
  {
    value: 1,
    str: "周一"
  }, {
    value: 2,
    str: "周二"
  },
  {
    value: 3,
    str: "周三"
  }, {
    value: 4,
    str: "周四"
  }, {
    value: 5,
    str: "周五"
  }, {
    value: 6,
    str: "周六"
  }
];
const getfutureFiveDays = () => {
  let today = new Date();
  let rs = [];
  let days = [
    new Date(today.getTime() + dayTimeStamp),
    new Date(today.getTime() + dayTimeStamp * 2),
    new Date(today.getTime() + dayTimeStamp * 3),
    new Date(today.getTime() + dayTimeStamp * 4),
    new Date(today.getTime() + dayTimeStamp * 5)
  ];
  days.forEach(day=>{
    rs.push({
      dateTime:formatTime(day),
      dayStr:weekdays.filter(weekday=>weekday.value==day.getDay())[0].str,
      date:day.getDate()
    })
  })
  return rs;
}

module.exports = {
  formatTime: formatTime,
  getfutureFiveDays:getfutureFiveDays
}