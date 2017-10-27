/**
 * generated by Xtext 2.12.0
 */
package com.hribol.bromium.dsl.bromium;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getName <em>Name</em>}</li>
 *   <li>{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getActionDefinition <em>Action Definition</em>}</li>
 *   <li>{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getWebDriverAction <em>Web Driver Action</em>}</li>
 *   <li>{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getExpectHttpRequest <em>Expect Http Request</em>}</li>
 * </ul>
 *
 * @see com.hribol.bromium.dsl.bromium.BromiumPackage#getApplicationAction()
 * @model
 * @generated
 */
public interface ApplicationAction extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.hribol.bromium.dsl.bromium.BromiumPackage#getApplicationAction_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Action Definition</b></em>' containment reference list.
   * The list contents are of type {@link com.hribol.bromium.dsl.bromium.ActionDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action Definition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action Definition</em>' containment reference list.
   * @see com.hribol.bromium.dsl.bromium.BromiumPackage#getApplicationAction_ActionDefinition()
   * @model containment="true"
   * @generated
   */
  EList<ActionDefinition> getActionDefinition();

  /**
   * Returns the value of the '<em><b>Precondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Precondition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precondition</em>' containment reference.
   * @see #setPrecondition(Precondition)
   * @see com.hribol.bromium.dsl.bromium.BromiumPackage#getApplicationAction_Precondition()
   * @model containment="true"
   * @generated
   */
  Precondition getPrecondition();

  /**
   * Sets the value of the '{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getPrecondition <em>Precondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Precondition</em>' containment reference.
   * @see #getPrecondition()
   * @generated
   */
  void setPrecondition(Precondition value);

  /**
   * Returns the value of the '<em><b>Web Driver Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Web Driver Action</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Web Driver Action</em>' containment reference.
   * @see #setWebDriverAction(WebDriverAction)
   * @see com.hribol.bromium.dsl.bromium.BromiumPackage#getApplicationAction_WebDriverAction()
   * @model containment="true"
   * @generated
   */
  WebDriverAction getWebDriverAction();

  /**
   * Sets the value of the '{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getWebDriverAction <em>Web Driver Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Web Driver Action</em>' containment reference.
   * @see #getWebDriverAction()
   * @generated
   */
  void setWebDriverAction(WebDriverAction value);

  /**
   * Returns the value of the '<em><b>Postcondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postcondition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postcondition</em>' containment reference.
   * @see #setPostcondition(Postcondition)
   * @see com.hribol.bromium.dsl.bromium.BromiumPackage#getApplicationAction_Postcondition()
   * @model containment="true"
   * @generated
   */
  Postcondition getPostcondition();

  /**
   * Sets the value of the '{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getPostcondition <em>Postcondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postcondition</em>' containment reference.
   * @see #getPostcondition()
   * @generated
   */
  void setPostcondition(Postcondition value);

  /**
   * Returns the value of the '<em><b>Expect Http Request</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expect Http Request</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expect Http Request</em>' attribute.
   * @see #setExpectHttpRequest(String)
   * @see com.hribol.bromium.dsl.bromium.BromiumPackage#getApplicationAction_ExpectHttpRequest()
   * @model
   * @generated
   */
  String getExpectHttpRequest();

  /**
   * Sets the value of the '{@link com.hribol.bromium.dsl.bromium.ApplicationAction#getExpectHttpRequest <em>Expect Http Request</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expect Http Request</em>' attribute.
   * @see #getExpectHttpRequest()
   * @generated
   */
  void setExpectHttpRequest(String value);

} // ApplicationAction
