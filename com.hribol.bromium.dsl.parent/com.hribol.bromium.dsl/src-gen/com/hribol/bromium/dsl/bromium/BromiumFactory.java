/**
 * generated by Xtext 2.12.0
 */
package com.hribol.bromium.dsl.bromium;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.hribol.bromium.dsl.bromium.BromiumPackage
 * @generated
 */
public interface BromiumFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BromiumFactory eINSTANCE = com.hribol.bromium.dsl.bromium.impl.BromiumFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Application Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application Action</em>'.
   * @generated
   */
  ApplicationAction createApplicationAction();

  /**
   * Returns a new object of class '<em>Web Driver Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Web Driver Action</em>'.
   * @generated
   */
  WebDriverAction createWebDriverAction();

  /**
   * Returns a new object of class '<em>Element With Id Is Present</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element With Id Is Present</em>'.
   * @generated
   */
  ElementWithIdIsPresent createElementWithIdIsPresent();

  /**
   * Returns a new object of class '<em>Click On Element With Id</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Click On Element With Id</em>'.
   * @generated
   */
  ClickOnElementWithId createClickOnElementWithId();

  /**
   * Returns a new object of class '<em>Page Load</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Page Load</em>'.
   * @generated
   */
  PageLoad createPageLoad();

  /**
   * Returns a new object of class '<em>Type Text In Element Found By Css Selector</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Text In Element Found By Css Selector</em>'.
   * @generated
   */
  TypeTextInElementFoundByCssSelector createTypeTextInElementFoundByCssSelector();

  /**
   * Returns a new object of class '<em>Version</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Version</em>'.
   * @generated
   */
  Version createVersion();

  /**
   * Returns a new object of class '<em>Three Dotted Version</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Three Dotted Version</em>'.
   * @generated
   */
  ThreeDottedVersion createThreeDottedVersion();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  BromiumPackage getBromiumPackage();

} //BromiumFactory