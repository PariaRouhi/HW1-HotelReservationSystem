# HW1-HotelReservationSystem
تغییرات مرحله اول:
<table border="1" cellspacing="0" cellpadding="6" style="border-collapse:collapse; text-align:center;">
  <tr>
    <th>ردیف</th>
    <th>تغییرات مربوط به افزودن روش جدید ارسال پیام (SMS)</th>
    <th>تغییرات مربوط به افزودن روش جدید پرداخت (ONSITE)</th>
  </tr>
  <tr>
    <td>1</td>
    <td>
      <b>SmsSender</b><br>
      ایجاد کلاس جدید که interface MessageSender را پیاده‌سازی می‌کند و متد sendEmail دارد
    </td>
    <td>
      <b>PaymentProcessor</b><br>
      تغییر: افزودن متد جدید payOnSite(double amount)
    </td>
  </tr>
  <tr>
    <td>2</td>
    <td>
      <b>ReservationService</b><br>
      افزودن case SMS در switch نوتیفایر برای ایجاد SmsSender و ارسال پیامک
    </td>
    <td>
      <b>ReservationService</b><br>
      افزودن case ONSITE در switch پرداخت برای فراخوانی payOnSite
    </td>
  </tr>
</table>






تحلیل اصول شی گرایی گام دوم:

<table border="1" cellspacing="0" cellpadding="6" style="border-collapse: collapse; text-align: center; width: 100%;">
  <tr>
    <th>اصل</th>
    <th>کلاس / مورد</th>
    <th>علت برقراری / نقض</th>
  </tr>
  
  <tr><td><b>SRP (نقض)</b></td><td>ReservationService</td><td>چند مسئولیت مختلف: مدیریت رزرو، تخفیف شهر پاریس، چاپ فاکتور، ارسال نوتیفیکیشن، پردازش پرداخت</td></tr>

  <tr><td><b>SRP (برقراری)</b></td><td>Customer</td><td>فقط نگهداری اطلاعات مشتری</td></tr>
  <tr><td><b>SRP (برقراری)</b></td><td>Room</td><td>فقط نگهداری اطلاعات اتاق</td></tr>
  <tr><td><b>SRP (برقراری)</b></td><td>Reservation</td><td>فقط نگهداری اطلاعات رزرو و محاسبه قیمت کل</td></tr>
  <tr><td><b>SRP (برقراری)</b></td><td>PaymentProcessor</td><td>فقط پردازش پرداخت</td></tr>
  <tr><td><b>SRP (برقراری)</b></td><td>EmailSender / SmsSender</td><td>هرکدام فقط یک نوع پیام ارسال می‌کنند</td></tr>

  <tr><td><b>OCP (نقض)</b></td><td>ReservationService</td><td>افزودن روش پرداخت یا نوتیفیکیشن جدید نیازمند تغییر switch است</td></tr>
  <tr><td><b>OCP (نقض)</b></td><td>PaymentProcessor</td><td>افزودن روش پرداخت جدید نیازمند افزودن متد جدید است</td></tr>
  <tr><td><b>OCP (برقراری)</b></td><td>MessageSender</td><td>می‌توان پیاده‌سازی‌های جدید ایجاد کرد بدون تغییر کد موجود</td></tr>

  <tr><td><b>LSP (نقض)</b></td><td>LuxuryRoom</td><td>متد addFreeDinner در Room نیست → جانشینی ناقص</td></tr>
  <tr><td><b>LSP (نقض)</b></td><td>ReservationService</td><td>تغییر مستقیم مقدار room.price → رفتار غیرمنتظره</td></tr>
  <tr><td><b>LSP (برقراری)</b></td><td>Room</td><td>در صورت عدم استفاده از ویژگی اضافی LuxuryRoom جایگزینی ممکن است</td></tr>

  <tr><td><b>ISP (نقض)</b></td><td>MessageSender</td><td>نام متد sendEmail حتی برای SMS استفاده شده</td></tr>
  <tr><td><b>ISP (برقراری)</b></td><td>سایر کلاس‌ها</td><td>وابستگی غیرضروری ندارند</td></tr>

  <tr><td><b>DIP (نقض)</b></td><td>ReservationService</td><td>وابستگی مستقیم به کلاس‌های concrete با new</td></tr>
  <tr><td><b>DIP (برقراری)</b></td><td>EmailSender / SmsSender</td><td>وابسته به abstraction (MessageSender) هستند</td></tr>

  <tr><td><b>PLK (نقض)</b></td><td>ReservationService</td><td>دسترسی زنجیره‌ای زیاد به res.customer و res.room</td></tr>
  <tr><td><b>PLK (برقراری)</b></td><td>Reservation</td><td>استفاده از totalPrice() به‌جای دسترسی مستقیم</td></tr>

  <tr><td><b>CRP (برقراری)</b></td><td>package models</td><td>کلاس‌های مرتبط کنار هم قرار دارند</td></tr>
  <tr><td><b>CRP (برقراری)</b></td><td>package services</td><td>کلاس‌های سرویس‌دهی کنار هم هستند</td></tr>
  <tr><td><b>CRP (برقراری)</b></td><td>package constants</td><td>enumهای ثابت کنار هم هستند</td></tr>
</table>
