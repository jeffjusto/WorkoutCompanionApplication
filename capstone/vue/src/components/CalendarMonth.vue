<template>
    <div class="calendar-month">
        <div class="calendar-month-header">
            <CalendarDateIndicator
            :selected-date="selectedDate"
            class="calendar-month-header-selected-month"
            />
            <CalendarDateSelector
            :current-date="today"
            :selected-date="selectedDate"
            @dateSelected="selectDate"
            />
        </div>
        <CalendarWeekdays/>

        <ol class="days-grid">
            <CalendarMonthDayItem
            v-for="day in days"
            :key="day.date"
            :day="day"
            :is-today="day.date === today"
            />

        </ol>

    </div>
</template>

<script>
import dayjs from "dayjs";
import weekday from "dayjs/plugin/weekday";
import weekOfYear from "dayjs/plugin/weekOfYear";
import CalendarDateIndicator from "../components/CalendarDateIndicator.vue";
import CalendarDateSelector from "../components/CalendarDateSelector.vue";
import CalendarMonthDayItem from "../components/CalendarMonthDayItem.vue";
import CalendarWeekdays from "../components/CalendarWeekdays.vue";

dayjs.extend(weekday);
dayjs.extend(weekOfYear);

export default {

    name: "CalendarMonth",

    components: {
       CalendarMonthDayItem,
    CalendarDateIndicator,
    CalendarDateSelector,
    CalendarWeekdays
    },

    data(){
        return{
            selectedDate: dayjs()
        };
    },

    computed: {
        days() {
      return [
        ...this.previousMonthDays,
        ...this.currentMonthDays,
        ...this.nextMonthDays
      ];
    },
    today() {
      return dayjs().format("YYYY-MM-DD");
    },

    month() {
      return Number(this.selectedDate.format("M"));
    },

    year() {
      return Number(this.selectedDate.format("YYYY"));
    },
        numberOfDaysInMonth(){
            return dayjs(this.selectedDate).daysInMonth();
        },

        currentMonthDays(){
            return [...Array(this.numberOfDaysInMonth)].map((day, index) => {
                return {
                    date: dayjs(`${this.year}-${this.month}-${index + 1}`).format("YYYY-MM-DD"),
                    isCurrentMonth: true
                };
            });
        },
        previousMonthDays(){
            const firstDayOfTheMonthWeekday = this.getWeekday(this.currentMonthDays[0].date);
            const previousMonth = dayjs(`${this.year}-${this.month}-01`).subtract(1, "month");

            const visibleNumberOfDaysFromPreviousMonth = firstDayOfTheMonthWeekday ? firstDayOfTheMonthWeekday - 1 : 6;
            const previousMonthLastMondayDayOfMonth = dayjs(this.currentMonthDays[0].date).subtract(visibleNumberOfDaysFromPreviousMonth, "day").date();

            return [...Array(visibleNumberOfDaysFromPreviousMonth)].map((day, index) => {
                return {
                    date: dayjs(`${previousMonth.year()}-${previousMonth.month() + 1}-${previousMonthLastMondayDayOfMonth + index}`).format("YYYY-MM-DD"),
                    isCurrentMonth: false
                };
            });

        },
        nextMonthDays() {
            const lastDayOfTheMonthWeekday = this.getWeekday(`${this.year}-${this.month}-${this.currentMonthDays.length}`);
            const nextMonth = dayjs(`${this.year}-${this.month}-01`).add(1, "month");
            const visibleNumberOfDaysFromNextMonth = lastDayOfTheMonthWeekday ? 7 - lastDayOfTheMonthWeekday : lastDayOfTheMonthWeekday;

            return [...Array(visibleNumberOfDaysFromNextMonth)].map((day, index) => {
                return {
                    date: dayjs(`${nextMonth.year()}-${nextMonth.month() + 1}-${index + 1}`).format("YYYY-MM-DD"),
                    isCurrentMonth: false
                 };
             });
         },
         
         
  
    },

    methods: {
        selectDate(newSelectedDate){
            this.selectedDate = newSelectedDate;
        },
        getWeekday(date){
            return dayjs(date).weekday();
        }
    }
};
</script>

<style>
/* Merge Fix */
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
  margin-top: 60px;
}

body {
  font-family: sans-serif;
  font-weight: 100;
  --grey-100: #E4E9F0;
  --grey-200: #CFD7E3;
  --grey-300: #B5C0CD;
  --grey-800: #3E4E63;
  --grid-gap: 1px;
  --day-label-size: 20px;
}

ol,
li {
  padding: 0;
  margin: 0;
  list-style: none;
}

.calendar-month {
  margin-left: auto;
  margin-right: auto;
}

.calendar-month-header {
  display: flex;
  justify-content: space-between;
  background-color: #fff;
  padding: 10px;
}
.button{
  align-items: center;
  gap: 50px;
  background-color: whitesmoke;
  border-color: thistle;
  height: 50px;
  width: 50px;
  margin: 50px;
  padding: 50px 50px 50px 50px;
}

/* Original */
.calendar-month {
  position: relative;
  background-color: var(--grey-200);
  border: solid 1px var(--grey-300);
}

.day-of-week {
  color: var(--grey-800);
  font-size: 18px;
  background-color: #fff;
  padding-bottom: 5px;
  padding-top: 10px;
}

.day-of-week,
.days-grid {
  display: grid;
  grid-template-columns: repeat(7, 1fr);
}

.day-of-week > * {
  text-align: right;
  padding-right: 5px;
}

.days-grid {
  height: 100%;
  position: relative;
  grid-column-gap: var(--grid-gap);
  grid-row-gap: var(--grid-gap);
  border-top: solid 1px var(--grey-200);
}
</style>
