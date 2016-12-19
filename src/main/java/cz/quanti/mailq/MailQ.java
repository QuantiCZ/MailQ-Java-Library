package cz.quanti.mailq;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.quanti.mailq.di.DefaultModule;
import cz.quanti.mailq.entities.v2.*;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import cz.quanti.mailq.resources.v2.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MailQ {

    private final CampaignResource campaignResource;
    private final CompanyResource companyResource;
    private final UnsubscriberResource unsubscriberResource;
    private final LogMessageResource logMessageResource;
    private final NewsletterResource newsletterResource;
    private final SmsNewsletterResource smsNewsletterResource;
    private final NotificationResource notificationResource;
    private final SmsNotificationResource smsNotificationResource;
    private final RecipientsListResource recipientsListResource;
    private final SenderEmailResource senderEmailResource;
    private final UserResource userResource;
    private final ValidatorResource validatorResource;

    /**
     * Create new MailQ object
     * @param baseUrl - URL to API
     * @param companyId - Company ID - you can check your company ID in GUI
     * @param apiKey - Company ID - you can check your API key in GUI
     */
    public MailQ(String baseUrl, Integer companyId, String apiKey) {
        Injector injector = Guice.createInjector(new DefaultModule(baseUrl,companyId,apiKey));
        campaignResource = injector.getInstance(CampaignResource.class);
        companyResource = injector.getInstance(CompanyResource.class);
        unsubscriberResource = injector.getInstance(UnsubscriberResource.class);
        logMessageResource = injector.getInstance(LogMessageResource.class);
        newsletterResource = injector.getInstance(NewsletterResource.class);
        smsNewsletterResource = injector.getInstance(SmsNewsletterResource.class);
        notificationResource = injector.getInstance(NotificationResource.class);
        smsNotificationResource = injector.getInstance(SmsNotificationResource.class);
        recipientsListResource = injector.getInstance(RecipientsListResource.class);
        senderEmailResource = injector.getInstance(SenderEmailResource.class);
        userResource = injector.getInstance(UserResource.class);
        validatorResource = injector.getInstance(ValidatorResource.class);
    }


    /**
     * Get all campaigns
     * @param pagination
     * @return CampaignEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public CampaignsEntity getCampaings(Pagination pagination) throws ApiException, InvalidRequestException {
        return this.campaignResource.getCampaigns(pagination);
    }

    /**
     * Get single campaign
     * @param id
     * @return CampaignEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public CampaignEntity getCampaing(Long id) throws ApiException, InvalidRequestException {
        return this.campaignResource.getCampaign(id);
    }

    /**
     * Get single company
     * @return CompanyEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public CompanyEntity getCompany() throws ApiException, InvalidRequestException {
        return this.companyResource.getCompany();
    }

    /**
     * Unsubscribe email addresses from all recipients lists. This is global unsubscribe. If you want to
     * unsubscribe only from specific recipients list check unsubscribe method with recipients list ID parameter.
     * @param emails - email addresses
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void unsubscribe(String... emails) throws InvalidRequestException, ApiException {
        if (emails.length == 1) {
            this.unsubscriberResource.unsubscribe(emails[0]);
        }
        else {
            Set<String> emailsSet = new HashSet<>(Arrays.asList(emails));
            this.unsubscriberResource.unsubscribe(emailsSet);
        }
    }

    /**
     * Unsubscribe email addresses from all recipients lists. This is global unsubscribe. If you want to
     * unsubscribe only from specific recipients list check unsubscribe method with recipients list ID parameter.
     * @param emails
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void unsubscribe(Set<String> emails) throws InvalidRequestException, ApiException {
        this.unsubscriberResource.unsubscribe(emails);
    }

    /**
     * Get all global unsubscribers
     * @param from - filter to unsubscriptions created after this datetime
     * @param pagination
     * @return UnsubscribersEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public UnsubscribersEntity getUnsubscribers(LocalDateTime from,Pagination pagination) throws InvalidRequestException, ApiException {
        return this.unsubscriberResource.getUnsubscribers(from,pagination);
    }

    /**
     * Get single unsubscriber by email address
     * @param email - email address of unsubscriber
     * @return UnsubscribersEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public UnsubscribersEntity getUnsubscriber(String email) throws InvalidRequestException, ApiException {
        return this.unsubscriberResource.getUnsubscriber(email);
    }

    /**
     * Remove delete unsubscriber
     * @param email
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void deleteUnsubscriber(String email) throws InvalidRequestException, ApiException {
        this.unsubscriberResource.deleteUnsubscribe(email);
    }

    /**
     * Get all log messages from system
     * @param pagination
     * @return LogMessagesEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public LogMessagesEntity getLogMessages(Pagination pagination) throws InvalidRequestException, ApiException {
        return this.logMessageResource.getLogMessages(pagination);
    }

    /**
     * Get single log message from system
     * @param id - id of log message
     * @return LogMessageEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public LogMessageEntity getLogMessage(Long id) throws InvalidRequestException, ApiException {
        return this.logMessageResource.getLogMessage(id);
    }

    /**
     * Get newsletters of company
     * @param pagination
     * @return NewslettersEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public NewslettersEntity getNewsletters(Pagination pagination) throws InvalidRequestException, ApiException {
        return this.newsletterResource.getNewsletters(pagination);
    }

    /**
     * Create newsletter
     * This action will not automatically start newsletter. You have to call startNewsletter to confirm you want to
     * send all emails.
     * @param newsletterEntity
     * @return NewsletterEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public NewsletterEntity createNewsletter(NewsletterEntity newsletterEntity) throws InvalidRequestException, ApiException {
        return this.newsletterResource.createNewsletter(newsletterEntity);
    }

    /**
     * Get tags of all newsletters
     * @return TagsEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public TagsEntity getNewslettersTags() throws InvalidRequestException, ApiException  {
        return this.newsletterResource.getTags();
    }

    /**
     * Get newsletter by user specific code. Code is unique in company.
     * @param code
     * @return NewsletterEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public NewsletterEntity getNewsletterByCode(String code) throws InvalidRequestException, ApiException  {
        return this.newsletterResource.getNewsletterByCode(code);
    }

    /**
     * Get newsletter
     * @param newsletterId - ID of newsletter
     * @return NewsletterEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public NewsletterEntity getNewsletter(Long newsletterId) throws InvalidRequestException, ApiException  {
        return this.newsletterResource.getNewsletter(newsletterId);
    }

    /**
     * Update newsletter
     * You can update newsletter only before you call startNewsletter. If you already started newsletter you can
     * stop it by stopNewsletter method.
     * @param newsletter
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void updateNewsletter(NewsletterEntity newsletter) throws InvalidRequestException, ApiException  {
        this.newsletterResource.updateNewsletter(newsletter);
    }

    /**
     * Delete newsletter
     * @param newsletterId
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void deleteNewsletter(Long newsletterId) throws InvalidRequestException, ApiException  {
        this.newsletterResource.deleteNewsletter(newsletterId);
    }

    /**
     * Start preparing of newsletter. If start of newsletter is not in range (past to now+1hour) newsletter can be
     * stopped by stopNewsletter. Otherwise it cannot be stopped.
     * @param newsletterId
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void startNewsletter(Long newsletterId) throws InvalidRequestException, ApiException  {
        this.newsletterResource.startNewsletter(newsletterId);
    }

    /**
     * Stop preparing of newsletter. it is allowed only if newsletter start is after now+1hour.
     * @param newsletterId
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void stopNewsletter(Long newsletterId) throws InvalidRequestException, ApiException  {
        this.newsletterResource.stopNewsletter(newsletterId);
    }

    /**
     * Send test e-mail. This will send e-mail with data from first row of recipients list.
     * @param newsletterId
     * @param email
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void sendTestEmail(Long newsletterId, String email) throws ApiException, InvalidRequestException {
        this.newsletterResource.sendTestEmail(newsletterId,email);
    }

    /**
     * Get SMS newsletters
     * @param pagination
     * @return SmsNewslettersEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public SmsNewslettersEntity getSmsNewsletters(Pagination pagination) throws InvalidRequestException, ApiException {
        return this.smsNewsletterResource.getNewsletters(pagination);
    }

    /**
     * Create SMS newsletter. This action will not automatically start newsletter. You have to call startSmsNewsletter to confirm you want to
     * send all SMS.
     * @param newsletterEntity
     * @return SmsNewsletterEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public SmsNewsletterEntity createSmsNewsletter(SmsNewsletterEntity newsletterEntity) throws InvalidRequestException, ApiException {
        return this.smsNewsletterResource.createNewsletter(newsletterEntity);
    }

    /**
     * Get SMS newsletter
     * @param newsletterId
     * @return SmsNewsletterEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public SmsNewsletterEntity getSmsNewsletter(Long newsletterId) throws InvalidRequestException, ApiException {
        return this.smsNewsletterResource.getNewsletter(newsletterId);
    }

    /**
     * Update SMS newsletter. You can update newsletter only before you call startSmsNewsletter. If you already started newsletter you can
     * stop it by stopNewsletter method.
     * @param newsletter
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void updateSmsNewsletter(SmsNewsletterEntity newsletter) throws ApiException, InvalidRequestException {
        this.smsNewsletterResource.updateNewsletter(newsletter);
    }

    /**
     * Delete SMS newsletter
     * @param newsletterId
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void deleteSmsNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        this.smsNewsletterResource.deleteNewsletter(newsletterId);
    }

    /**
     * Start preparing of newsletter. If start of newsletter is not in range (past to now+1hour) newsletter can be
     * stopped by stopSmsNewsletter. Otherwise it cannot be stopped.
     * @param newsletterId
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void startSmsNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        this.smsNewsletterResource.startNewsletter(newsletterId);
    }

    /**
     * Stop preparing of newsletter. it is allowed only if newsletter start is after now+1hour.
     * @param newsletterId
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void stopSmsNewsletter(Long newsletterId) throws ApiException, InvalidRequestException {
        this.smsNewsletterResource.stopNewsletter(newsletterId);
    }

    /**
     * Send test SMS. This will sent normal SMS. It will be charged!
     * @param newsletterId
     * @param number
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void sendTestSms(Long newsletterId, String number) throws ApiException, InvalidRequestException {
        this.smsNewsletterResource.sendTestSms(newsletterId,number);
    }

    /**
     * Get notifications
     * @param pagination
     * @return NotificationsEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public NotificationsEntity getNotifications(Pagination pagination) throws ApiException, InvalidRequestException  {
        return this.notificationResource.getNotifications(pagination);
    }

    /**
     * Create notification. If you want to send notification check sendNotificationEmail method.
     * @param notification
     * @return NotificationEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public NotificationEntity createNotification(NotificationEntity notification) throws ApiException, InvalidRequestException {
        return this.notificationResource.createNotification(notification);
    }

    /**
     * Get notification
     * @param notificationId
     * @return NotificationEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public NotificationEntity getNotification(Long notificationId) throws ApiException, InvalidRequestException  {
        return this.notificationResource.getNotification(notificationId);
    }


    /**
     * Update notification
     * @param notification
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void updateNotification(NotificationEntity notification) throws ApiException, InvalidRequestException {
        this.notificationResource.updateNotification(notification);
    }

    /**
     * Delete notification
     * @param notificationId
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void deleteNotification(Long notificationId) throws ApiException, InvalidRequestException {
        this.notificationResource.deleteNotification(notificationId);
    }

    /**
     * Send notification e-mail. This will send e-mail using notification and data you provide.
     * Template using mustache templating system.
     * @param notificationId
     * @param notificationData
     * @return NotificationDataEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public NotificationDataEntity sendNotificationEmail(Long notificationId, NotificationDataEntity notificationData) throws ApiException, InvalidRequestException {
        return this.notificationResource.sendNotification(notificationId,notificationData);
    }

    /**
     * Get notifications data. You can find all notifications send to specific e-mail address.
     * @param notificationId
     * @param email
     * @param pagination
     * @return NotificationsDataEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public NotificationsDataEntity getNotificationsData(Long notificationId, String email, Pagination pagination) throws ApiException, InvalidRequestException {
        return this.notificationResource.getNotificationsData(notificationId,email,pagination);
    }

    /**
     * Get notification data
     * @param notificationId
     * @param notificationDataId
     * @return NotificationDataEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public NotificationDataEntity getNotificationData(Long notificationId, String notificationDataId) throws ApiException, InvalidRequestException {
        return this.notificationResource.getNotificationData(notificationId, notificationDataId);
    }

    /**
     * Create SMS notification
     * @param notification
     * @return SmsNotificationEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public SmsNotificationEntity createSmsNotification(SmsNotificationEntity notification) throws ApiException, InvalidRequestException {
        return this.smsNotificationResource.createNotification(notification);
    }

    /**
     * Get SMS notifications
     * @param pagination
     * @return SmsNotificationsEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public SmsNotificationsEntity getSmsNotifications(Pagination pagination) throws ApiException, InvalidRequestException {
        return this.smsNotificationResource.getNotifications(pagination);
    }

    /**
     * Get SMS notification
     * @param notificationId
     * @return SmsNotificationEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public SmsNotificationEntity getSmsNotification(Long notificationId) throws ApiException, InvalidRequestException {
        return this.smsNotificationResource.getNotification(notificationId);
    }

    /**
     * Update SMS notification
     * @param notification
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void updateSmsNotification(SmsNotificationEntity notification) throws ApiException, InvalidRequestException {
        this.smsNotificationResource.updateNotification(notification);
    }

    /**
     * Delete SMS notification
     * @param notificationId
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void deleteSmsNotification(Long notificationId) throws ApiException, InvalidRequestException {
        this.smsNotificationResource.deleteNotification(notificationId);
    }

    /**
     * Send SMS notification. This will be charged!
     * @param notificationId
     * @param notification
     * @return
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public SmsNotificationDataEntity sendSmsNotification(Long notificationId, SmsNotificationDataEntity notification) throws ApiException, InvalidRequestException {
        return this.smsNotificationResource.sendSmsNotification(notificationId,notification);
    }

    /**
     * Send batch of SMS. Maximum batch size is 100. Always check response to find out status
     * of every SMS in batch. This will be charged!
     * @param notificationId
     * @param notificationBatch
     * @return SmsBatchResultEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public SmsBatchResultEntity sendSmsBatchNotification(Long notificationId, SmsNotificationBatchEntity notificationBatch) throws ApiException, InvalidRequestException {
        return this.smsNotificationResource.sendSmsBatchNotification(notificationId,notificationBatch);
    }

    /**
     * Get SMS notification data.
     * @param notificationId
     * @param notificationDataId
     * @return
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public SmsNotificationDataEntity getSmsNotificationData(Long notificationId, String notificationDataId) throws ApiException, InvalidRequestException {
        return this.smsNotificationResource.getNotificationData(notificationId,notificationDataId);
    }

    /**
     * Get recipients lists
     * @param pagination
     * @return RecipientsListsEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public RecipientsListsEntity getRecipientsLists(Pagination pagination) throws ApiException, InvalidRequestException {
        return this.recipientsListResource.getRecipientsLists(pagination);
    }

    /**
     * Get recipients lists by email address. This will filter all company recipients list to
     * lists which contains specific e-mail address.
     * @param email
     * @return RecipientsListsEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public RecipientsListsEntity getRecipientsListsByEmail(String email) throws ApiException, InvalidRequestException {
        return this.recipientsListResource.getRecipientsListsByEmail(email);
    }

    /**
     * Get recipient list
     * @param recipientsListId
     * @return RecipientsListEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public RecipientsListEntity getRecipientsList(Long recipientsListId) throws ApiException, InvalidRequestException {
        return this.recipientsListResource.getRecipientsList(recipientsListId);
    }

    /**
     * Create recipients list. You can specify which variable will be used. It is possible only
     * on creation.
     * @param recipientsList
     * @return RecipientsListEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public RecipientsListEntity createRecipientsList(RecipientsListEntity recipientsList) throws ApiException, InvalidRequestException {
        return this.recipientsListResource.createRecipientsList(recipientsList);
    }

    /**
     * Delete recipients list. List will be deleted only if it is empty. If you want
     * to delete list with entries use same method with second parameter set to true - it wil;
     * disable check.
     * @param recipientsListId
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void deleteRecipientsList(Long recipientsListId) throws ApiException, InvalidRequestException {
         this.deleteRecipientsList(recipientsListId,false);
    }

    /**
     * Delete recipients list. List will be deleted only if it is empty. If you want
     * to delete list with entries set second parameter to true - it wil;
     * disable check.
     * @param recipientsListId
     * @param complete - If it is set to true it will delete list even if they are entries in it.
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void deleteRecipientsList(Long recipientsListId, boolean complete) throws ApiException, InvalidRequestException {
        this.recipientsListResource.deleteRecipientsList(recipientsListId,complete);
    }

    /**
     * Add multiple recipients to the list with validation of e-mail addresses.
     * @param recipientsListId
     * @param entries
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void addRecipientsToList(Long recipientsListId, List<RecipientsListEntryEntity> entries) throws ApiException, InvalidRequestException {
        this.addRecipientsToList(recipientsListId,entries,true);
    }

    /**
     * Add multiple recipients to the list. If you do not want to validate e-mail addresses set third parameter to false.
     * @param recipientsListId
     * @param entries
     * @param validate - If it is set to true email addresses will be validated.
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void addRecipientsToList(Long recipientsListId, List<RecipientsListEntryEntity> entries, Boolean validate) throws ApiException, InvalidRequestException {
        RecipientsListEntriesEntity recipientsListEntries = new RecipientsListEntriesEntity(entries);
        this.recipientsListResource.addRecipientsToList(recipientsListId,recipientsListEntries,validate);
    }

    /**
     * Get entries from recipients list
     * @param recipientsListId
     * @param pagination
     * @return RecipientsListEntriesEntity
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public RecipientsListEntriesEntity getRecipientsFromList(Long recipientsListId, Pagination pagination) throws ApiException, InvalidRequestException {
        return this.recipientsListResource.getRecipientsFromList(recipientsListId, pagination);
    }

    /**
     * Update entry from recipients list
     * @param recipientsListId
     * @param recipientsListEntry
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void updateRecipientFromList(Long recipientsListId,RecipientsListEntryEntity recipientsListEntry) throws ApiException, InvalidRequestException {
        this.recipientsListResource.updateRecipientFromList(recipientsListId,recipientsListEntry,true);
    }

    /**
     * Update entry from recipients list
     * @param recipientsListId
     * @param recipientsListEntry
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void updateRecipientFromList(Long recipientsListId,RecipientsListEntryEntity recipientsListEntry, Boolean validate) throws ApiException, InvalidRequestException {
        this.recipientsListResource.updateRecipientFromList(recipientsListId,recipientsListEntry,validate);
    }

    /**
     * Delete entry from recipients list. If you do not want to send newsletters to user from this
     * recipient list, it is better to unsubscribe user rather then delete it.
     * @param recipientsListId
     * @param email
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void deleteRecipientFromList(Long recipientsListId, String email)  throws ApiException, InvalidRequestException  {
        this.recipientsListResource.deleteRecipientFromList(recipientsListId,email);
    }

    /**
     * Unsubscribe e-mail addresses from recipient list
     * @param recipientsListId
     * @param emails
     * @throws ApiException
     * @throws InvalidRequestException
     */
    public void unsubscribe(Long recipientsListId, Set<String> emails)  throws ApiException, InvalidRequestException  {
        this.recipientsListResource.unsubscribe(recipientsListId,emails);
    }

    /**
     * Unsubscribe e-mail addresses from recipient list
     * @param recipientsListId
     * @param emails
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void unsubscribe(Long recipientsListId,String... emails) throws InvalidRequestException, ApiException {
        if (emails.length == 1) {
            this.recipientsListResource.unsubscribe(recipientsListId,emails[0]);
        }
        else {
            Set<String> emailsSet = new HashSet<>(Arrays.asList(emails));
            this.recipientsListResource.unsubscribe(recipientsListId,emailsSet);
        }
    }

    /**
     * Get unsubscribers from recipients list
     * @param recipientsListId
     * @param pagination
     * @return UnsubscribersEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public UnsubscribersEntity getUnsubscribers(Long recipientsListId, Pagination pagination) throws InvalidRequestException, ApiException {
        return this.recipientsListResource.getUnsubscribers(recipientsListId, pagination);
    }

    /**
     * Get unsubscriber from recipients list
     * @param recipientsListId
     * @param email
     * @return
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public UnsubscriberEntity getUnsubscriber(Long recipientsListId, String email) throws InvalidRequestException, ApiException {
        return this.recipientsListResource.getUnsunscriber(recipientsListId,email);
    }

    /**
     * Delete unsubscriber from recipients list
     * @param recipientsListId
     * @param email
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void deleteUnsubscriber(Long recipientsListId, String email) throws InvalidRequestException, ApiException {
        this.recipientsListResource.deleteUnsubscriber(recipientsListId,email);
    }

    /**
     * Get sender e-mails. This is list of e-mail addresses you can use for sending e-mails.
     * If you want to add another with same domain you can do it in administration GUI. If it is
     * e-mail address with different domain then existing. You have to send request to support.
     * @return SenderEmailsEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public SenderEmailsEntity getSenderEmails() throws InvalidRequestException, ApiException {
        return this.senderEmailResource.getSenderEmails();
    }

    /**
     * Get sender e-mail
     * @param id
     * @return SenderEmailEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public SenderEmailEntity getSenderEmail(Long id) throws InvalidRequestException, ApiException {
        return this.senderEmailResource.getSenderEmail(id);
    }

    /**
     * Get users in company
     * @return UsersEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public UsersEntity getUsers() throws InvalidRequestException, ApiException {
        return this.userResource.getUsers();
    }

    /**
     * Get user
     * @param userId
     * @return UserEntity
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public UserEntity getUser(Long userId) throws InvalidRequestException, ApiException {
        return this.userResource.getUser(userId);
    }

    /**
     * Validate e-mail address. This validation also validate MX domain.
     * @param email
     * @throws InvalidRequestException
     * @throws ApiException
     */
    public void validate(String email) throws InvalidRequestException, ApiException {
        this.validatorResource.validate(email);
    }

}
