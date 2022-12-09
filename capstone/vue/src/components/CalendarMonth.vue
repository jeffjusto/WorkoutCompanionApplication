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
        CalendarDateIndicator,
        CalendarDateSelector,
        CalendarMonthDayItem,
        CalendarWeekdays
    },

    data(){
        return{
            selectedDate: dayjs(),
            today: dayjs().format("YYYY-MM-DD")
        };
    },

    computed: {
        days(){
            return [
               { date: "2020-06-29", isCurrentMonth: false },
        { date: "2022-11-30", isCurrentMonth: false },
        { date: "2022-12-01", isCurrentMonth: true },
        { date: "2022-12-02", isCurrentMonth: true },
        { date: "2022-12-03", isCurrentMonth: true },
        { date: "2022-12-04", isCurrentMonth: true },
        { date: "2022-12-05", isCurrentMonth: true },
        { date: "2022-12-06", isCurrentMonth: true },
        { date: "2022-12-07", isCurrentMonth: true },
        { date: "2022-12-08", isCurrentMonth: true },
        { date: "2022-12-09", isCurrentMonth: true },
        { date: "2022-12-10", isCurrentMonth: true },
        { date: "2022-12-11", isCurrentMonth: true },
        { date: "2022-12-12", isCurrentMonth: true },
        { date: "2022-12-13", isCurrentMonth: true },
        { date: "2022-12-14", isCurrentMonth: true },
        { date: "2022-12-15", isCurrentMonth: true },
        { date: "2022-12-16", isCurrentMonth: true },
        { date: "2022-12-17", isCurrentMonth: true },
        { date: "2022-12-18", isCurrentMonth: true },
        { date: "2022-12-19", isCurrentMonth: true },
        { date: "2022-12-20", isCurrentMonth: true },
        { date: "2022-12-21", isCurrentMonth: true },
        { date: "2022-12-22", isCurrentMonth: true },
        { date: "2022-12-23", isCurrentMonth: true },
        { date: "2022-12-24", isCurrentMonth: true },
        { date: "2022-12-25", isCurrentMonth: true },
        { date: "2022-12-26", isCurrentMonth: true },
        { date: "2022-12-27", isCurrentMonth: true },
        { date: "2022-12-28", isCurrentMonth: true },
        { date: "2022-12-29", isCurrentMonth: true },
        { date: "2022-12-30", isCurrentMonth: true },
        { date: "2022-12-31", isCurrentMonth: true },
        { date: "2023-01-01", isCurrentMonth: false },
        { date: "2023-01-02", isCurrentMonth: false }
       
            ];
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